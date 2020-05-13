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
import java.util.Date;
import java.util.List;

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
    @Autowired
    private BasicInformationService basicInformationService;


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
        MedicalRecord medicalRecord=medicalRecordMapper.selectByPrimaryKeyExcludingDeleted(id);
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

    CheckApply updateCheckApplyInternal(CheckApply checkApply, ResultMessage resultMessage){
        getCheckApplyById(checkApply.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                checkApplyMapper.updateByPrimaryKey(checkApply);
                return getCheckApplyById(checkApply.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public CheckApply updateCheckApplyExternal(CheckApply checkApply, ResultMessage resultMessage){
        CheckApply originalCheckApply=getCheckApplyById(checkApply.getId(),resultMessage);if(!resultMessage.isSuccessful()) return null;
        if(!originalCheckApply.getState().equals(checkApply.getState())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.CANNOT_CHANGE_STATES_THROUGH_UPDATES);
            return null;
        }

        if(!originalCheckApply.getMedicalId().equals(checkApply.getMedicalId())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.DO_NOT_CHANGE_MEDICAL_RECORD_ID);
            return null;
        }

        return updateCheckApplyInternal(checkApply,resultMessage);
    }


    MedicalRecord updateMedicalRecordInternal(MedicalRecord medicalRecord, ResultMessage resultMessage){
        getMedicalRecordById(medicalRecord.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                medicalRecordMapper.updateByPrimaryKey(medicalRecord);
                return getMedicalRecordById(medicalRecord.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public MedicalRecord updateMedicalRecordExternal(MedicalRecord medicalRecord, ResultMessage resultMessage){
        MedicalRecord originalMedicalRecord=getMedicalRecordById(medicalRecord.getId(),resultMessage);if(!resultMessage.isSuccessful()) return null;
        if(!originalMedicalRecord.getCaseState().equals(medicalRecord.getCaseState())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.CANNOT_CHANGE_STATES_THROUGH_UPDATES);
            return null;
        }
        return updateMedicalRecordInternal(medicalRecord,resultMessage);
    }

    private Prescription getPrescriptionById(Integer id){
        return prescriptionMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
    }

    //4.7
    public Prescription addPrescription(Prescription prescription, ResultMessage resultMessage){
        doctorDataCleaner.cleanPrescriptionForAddPrescription(prescription,resultMessage);if(!resultMessage.isSuccessful())return null;

        Prescription originalPrescription=getPrescriptionById(prescription.getMedicalId());
        if(originalPrescription!=null){
            resultMessage.sendClientError("The prescription of this medical record has existed. Please do not create again. 该病历的处方已存在。请不要重复创建。");
            return null;
        }

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


    Prescription updatePrescriptionInternal(Prescription prescription, ResultMessage resultMessage){
        getPrescriptionById(prescription.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                prescriptionMapper.updateByPrimaryKey(prescription);
                return getPrescriptionById(prescription.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public Prescription updatePrescriptionExternal(Prescription prescription,ResultMessage resultMessage){
        Prescription originalMedicalRecord=getPrescriptionById(prescription.getId(),resultMessage);if(!resultMessage.isSuccessful()) return null;
        if(!originalMedicalRecord.getPrescriptionState().equals(prescription.getPrescriptionState())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.CANNOT_CHANGE_STATES_THROUGH_UPDATES);
            return null;
        }

        if(!originalMedicalRecord.getUserId().equals(prescription.getUserId())){
            resultMessage.sendClientError("Please do not change the Doctor ID。请不要改变医生的主键 ID。");
            return null;
        }


        if(!originalMedicalRecord.getMedicalId().equals(prescription.getMedicalId())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.DO_NOT_CHANGE_MEDICAL_RECORD_ID);
            return null;
        }


        return updatePrescriptionInternal(prescription,resultMessage);
    }


    private CheckDetailed autoFillCheckDetailed(CheckDetailed checkDetailed, ResultMessage resultMessage){
        FmedItem fmedItem=basicInformationService.getFmedItemById(checkDetailed.getCheckprojid(),resultMessage);if(!resultMessage.isSuccessful()) return null;
        checkDetailed.setPrice(fmedItem.getPrice());
        checkDetailed.setDeptid(fmedItem.getDeptid());
        return checkDetailed;
    }

    public CheckDetailed addCheckDetailed(CheckDetailed checkDetailed,ResultMessage resultMessage){
        checkDetailed.setState(1);     // 1 - 未检验检查处置
        doctorDataCleaner.cleanCheckDetailed(checkDetailed,resultMessage);if(!resultMessage.isSuccessful()) return null;
        autoFillCheckDetailed(checkDetailed,resultMessage);if(!resultMessage.isSuccessful()) return null;


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



    CheckDetailed updateCheckDetailedInternal(CheckDetailed checkDetailed, ResultMessage resultMessage){
        getCheckDetailedById(checkDetailed.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                checkDetailedMapper.updateByPrimaryKey(checkDetailed);
                return getCheckDetailedById(checkDetailed.getId(),resultMessage);
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public CheckDetailed updateCheckDetailedExternal(CheckDetailed checkDetailed,ResultMessage resultMessage){
        CheckDetailed originalCheckDetailed=getCheckDetailedById(checkDetailed.getId(),resultMessage);if(!resultMessage.isSuccessful()) return null;
        if(!originalCheckDetailed.getState().equals(checkDetailed.getState())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.CANNOT_CHANGE_STATES_THROUGH_UPDATES);
            return null;
        }

        if(!originalCheckDetailed.getCheckappid().equals(checkDetailed.getCheckappid())){
            resultMessage.sendClientError(ResultMessage.ErrorMessage.DO_NOT_CHANGE_EXAMINATION_TEST_DISPOSAL_ID);
            return null;
        }

        doctorDataCleaner.cleanCheckDetailed(checkDetailed,resultMessage);if(!resultMessage.isSuccessful()) return null;
        autoFillCheckDetailed(checkDetailed,resultMessage);if(!resultMessage.isSuccessful()) return null;



        return updateCheckDetailedInternal(checkDetailed,resultMessage);
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
            }catch (DataIntegrityViolationException exception) {
                utilityService.dealDataIntegrityViolationException(resultMessage, exception);
                return null;
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.sendUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public List<CheckApply> getCheckAppliesByConditions(Integer userId,Integer state,Integer registrationId, ResultMessage resultMessage){
        List<CheckApply> allCheckApplies=checkApplyMapper.selectAllExcludingDeleted();
        List<CheckApply>  filteredCheckApplies=new ArrayList<>();
        for(CheckApply checkApply:allCheckApplies){
            if(
                    (userId==null||userId.equals(checkApply.getUserId()))
                    &&(state==null||state.equals(checkApply.getState()))
                    &&(registrationId==null||registrationId.equals(checkApply.getMedicalId()))
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

        checkApply.setCreationTime(new Date().getTime());//开立时间。

        checkApply= updateCheckApplyInternal(checkApply,resultMessage);if(!resultMessage.isSuccessful())return null;

        return checkApply;
    }


    public List<MedicalRecord> getMedicalRecordsByConditions(Integer userId, Integer patientId, Integer registrationId,Integer caseState,ResultMessage resultMessage){
        List<MedicalRecord> allMedicalRecords=medicalRecordMapper.selectAllExcludingDeleted();
        List<MedicalRecord>  filteredMedicalRecords=new ArrayList<>();
        for(MedicalRecord medicalRecord:allMedicalRecords){
            Register register=registrationService.getRegistrationById(medicalRecord.getRegisterId(),resultMessage);if(!resultMessage.isSuccessful())return null;

            if(
                    (userId==null||userId.equals(register.getUserid()))
                    &&(patientId==null||patientId.equals(register.getPatientid()))
                     &&(registrationId==null||registrationId.equals(register.getId()))
                     &&(caseState==null||caseState.equals(medicalRecord.getCaseState()))
            )
                filteredMedicalRecords.add(medicalRecord);

        }
        return filteredMedicalRecords;

    }



}
