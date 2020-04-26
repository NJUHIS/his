package com.njuhis.his.service;

import com.njuhis.his.datacleaner.DoctorDataCleaner;
import com.njuhis.his.mapper.*;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import com.sun.tools.javac.comp.Check;
//import com.sun.tools.javac.comp.Check;

@Service
public class DoctorService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private MedicalRecordMapper medicalRecordMapper;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private CheckApplyMapper checkApplyMapper;
    @Autowired
    private PrescriptionMapper prescriptionMapper;
    @Autowired
    private CheckDetailedMapper checkDetailedMapper;
    @Autowired
    private PrescriptionDetailedMapper prescriptionDetailedMapper;
    @Autowired
    private UtilityService utilityService;
    @Autowired
    private DoctorDataCleaner doctorDataCleaner;


    /**
     * 接診
     * @param registrationId
     * @param resultMessage
     * @return
     */
    public Register admit(Integer registrationId, ResultMessage resultMessage){

        Register registration=registrationService.getRegistrationById(registrationId,resultMessage);if(!resultMessage.isSuccessful()) return null;

        if(registration.getVisitstate()==1){
            resultMessage.sendClientError("The patient of this registration is visiting the doctor. 该挂号的病人正在被医生接诊中。");
            return null;
        }else if(registration.getVisitstate()!=0){
            resultMessage.sendClientError("The visit state is not 0-HaveNotVisited. 看诊状态不是 0-未看诊。");
            return null;
        }

        registration.setVisitstate(1);//掛號狀態：1-正在看診

        MedicalRecord medicalRecord=new MedicalRecord();
        medicalRecord.setRegisterId(registrationId);
        medicalRecord.setCaseState(2); //病歷狀態：進行中
        medicalRecord.setId(registrationId);

        registration.setMedicalRecordId(medicalRecord.getId());

        addMedicalRecord(medicalRecord,resultMessage);if(!resultMessage.isSuccessful()) return null;
        registration=registrationService.updateRegistration(registration,resultMessage);

        return registration;
    }

    public MedicalRecord getMedicalRecordById(Integer id,ResultMessage resultMessage){
        MedicalRecord medicalRecord=medicalRecordMapper.selectByPrimaryKey(id);
        if(medicalRecord==null){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.MEDICAL_RECORD_NOT_EXIST);
        }
        return medicalRecord;
    }


    public CheckApply getCheckApplyById(Integer id, ResultMessage resultMessage){
        CheckApply checkApply=checkApplyMapper.selectByPrimaryKeyExcludingDeleted(id);//如果失败，并不会抛出异常，只会返回null。
        if(checkApply!=null){
            return checkApply;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.EXAMINATION_TEST_DISPOSAL_NOT_EXIST);
            return null;
        }
    }

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord, ResultMessage resultMessage){
        try {
            medicalRecordMapper.insert(medicalRecord);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getMedicalRecordById(medicalRecord.getId(),resultMessage);
    }


    public CheckApply addCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        /**
         * 根据 medical record id 来 填写 user id。
         */
        doctorDataCleaner.cleanCheckApply(checkApply,resultMessage);if(!resultMessage.isSuccessful())return null;
        MedicalRecord medicalRecord=getMedicalRecordById(checkApply.getMedicalId(),resultMessage);if(!resultMessage.isSuccessful())return null;
        Register register=registrationService.getRegistrationById(medicalRecord.getRegisterId(),resultMessage);if(!resultMessage.isSuccessful())return null;
        checkApply.setUserId(register.getUserid());

        checkApply.setState(1);// 1 - 编辑中
        checkApply.setId(medicalRecord.getId());

        try {
            checkApplyMapper.insert(checkApply);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }

        return  getCheckApplyById(checkApply.getId(),resultMessage);
    }

    public CheckApply updateCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        getCheckApplyById(checkApply.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                checkApplyMapper.updateByPrimaryKey(checkApply);
                return getCheckApplyById(checkApply.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord, ResultMessage resultMessage){
        getMedicalRecordById(medicalRecord.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                medicalRecordMapper.updateByPrimaryKey(medicalRecord);
                return getMedicalRecordById(medicalRecord.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public Prescription addPrescription(Prescription prescription, ResultMessage resultMessage){
        doctorDataCleaner.cleanPrescriptionForAddPrescription(prescription,resultMessage);if(!resultMessage.isSuccessful())return null;
        Register register=registrationService.getRegistrationById(prescription.getMedicalId(),resultMessage);if(!resultMessage.isSuccessful())return null;
        prescription.setId(prescription.getMedicalId());
        prescription.setUserId(register.getUserid());
        prescription.setPrescriptionState(1);    //1 - 编辑中

        try {
            prescriptionMapper.insert(prescription);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getPrescriptionById(prescription.getId(),resultMessage);
    }


    public Prescription getPrescriptionById(Integer id, ResultMessage resultMessage){
        Prescription prescription=prescriptionMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(prescription!=null){
            return prescription;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.PRESCRIPTION_NOT_EXIST);
            return null;
        }

    }


    public Prescription updatePrescription(Prescription prescription, ResultMessage resultMessage){
        getPrescriptionById(prescription.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                prescriptionMapper.updateByPrimaryKey(prescription);
                return getPrescriptionById(prescription.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public CheckDetailed addCheckDetailed(CheckDetailed checkDetailed,ResultMessage resultMessage){
        try {
            checkDetailedMapper.insert(checkDetailed);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getCheckDetailedById(checkDetailed.getId(),resultMessage);
    }


    public CheckDetailed getCheckDetailedById(Integer id, ResultMessage resultMessage){
        CheckDetailed checkDetailed=checkDetailedMapper.selectByPrimaryKeyExcludingDeleted(id);//如果失败，并不会抛出异常，只会返回null。
        if(checkDetailed!=null){
            return checkDetailed;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.EXAMINATION_TEST_DISPOSAL_DETAIL_NOT_EXIST);
            return null;
        }

    }


    public CheckDetailed updateCheckDetailed(CheckDetailed checkDetailed, ResultMessage resultMessage){
        getCheckDetailedById(checkDetailed.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                checkDetailedMapper.updateByPrimaryKey(checkDetailed);
                return getCheckDetailedById(checkDetailed.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public PrescriptionDetailed addPrescriptionDetailed(PrescriptionDetailed prescriptionDetailed,ResultMessage resultMessage){
        try {
            prescriptionDetailedMapper.insert(prescriptionDetailed);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getPrescriptionDetailedById(prescriptionDetailed.getId(),resultMessage);
    }


    public PrescriptionDetailed getPrescriptionDetailedById(Integer id, ResultMessage resultMessage){
        PrescriptionDetailed prescriptionDetailed=prescriptionDetailedMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(prescriptionDetailed!=null){
            return prescriptionDetailed;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.PRESCRIPTION_DETAIL_NOT_EXIST);
            return null;
        }

    }


    public PrescriptionDetailed updatePrescriptionDetailed(PrescriptionDetailed prescriptionDetailed, ResultMessage resultMessage){
        getPrescriptionDetailedById(prescriptionDetailed.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                prescriptionDetailedMapper.updateByPrimaryKey(prescriptionDetailed);
                return getPrescriptionDetailedById(prescriptionDetailed.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public List<CheckApply> getCheckAppliesByConditions(Integer userId,Integer state,ResultMessage resultMessage){
        List<CheckApply> allCheckApplies=checkApplyMapper.selectAllExcludingDeleted();
        List<CheckApply>  filteredCheckApplies=new ArrayList<>();
        for(CheckApply checkApply:allCheckApplies){
            if(
                    (userId==null||userId.equals(checkApply.getUserId()))
                    &&(state==null||state.equals(checkApply.getState()))
            )
                filteredCheckApplies.add(checkApply);

        }
        return filteredCheckApplies;

    }

    public List<Prescription> getPrescriptionsByConditions(Integer userId,Integer prescriptionState,ResultMessage resultMessage){
        List<Prescription> allPrescriptions=prescriptionMapper.selectAllJoin();
        List<Prescription>  filteredPrescriptions=new ArrayList<>();
        for(Prescription prescription:allPrescriptions){
            if(
                    (userId==null||userId.equals(prescription.getUserId()))
                    &&(prescriptionState==null||prescriptionState.equals(prescription.getPrescriptionState()))
            )
                filteredPrescriptions.add(prescription);
        }
        return filteredPrescriptions;
    }

    public CheckApply confirmCheckApply(Integer checkApplyId, ResultMessage resultMessage){
        CheckApply checkApply=getCheckApplyById(checkApplyId,resultMessage);if(!resultMessage.isSuccessful())return null;

        if(checkApply.getState()!=1){//如果不是 1-编辑中
            resultMessage.sendClientError("The state is not 1-Editing. 状态不是 1-编辑中。");
            return null;
        }

        checkApply.setState(2);// 2-已开立并发出，未收费
        checkApply=updateCheckApply(checkApply,resultMessage);if(!resultMessage.isSuccessful())return null;

        return checkApply;
    }

    public CheckApply payCheckApply(Integer checkApplyId, ResultMessage resultMessage){
        CheckApply checkApply=getCheckApplyById(checkApplyId,resultMessage);if(!resultMessage.isSuccessful())return null;

        if(checkApply.getState()!=2){//如果不是 2-已开立并发出，未收费
            resultMessage.sendClientError("The state is not 2. 状态不是 2-已开出未收费");
            return null;
        }

        checkApply.setState(3);// 3 - 已收费，未检验检查处置
        checkApply=updateCheckApply(checkApply,resultMessage);if(!resultMessage.isSuccessful())return null;

        return checkApply;
    }

}
