package com.njuhis.his.service;

import com.njuhis.his.mapper.*;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
//import com.sun.tools.javac.comp.Check;
//import com.sun.tools.javac.comp.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




    public Register admit(Integer registrationId, ResultMessage resultMessage){
        Register registration=registrationService.getRegistrationById(registrationId,resultMessage);
        if(resultMessage.isSuccessful()){
            registration.setVisitstate(1);
            registration=registrationService.updateRegistration(registration,resultMessage);
        }
        return registration;
    }

    public MedicalRecord getMedicalRecordById(Integer id,ResultMessage resultMessage){
        MedicalRecord medicalRecord=medicalRecordMapper.selectByPrimaryKey(id);
        if(medicalRecord==null){
            resultMessage.setClientError(ResultMessage.ErrorMessage.MEDICAL_RECORD_NOT_EXIST);
        }
        return medicalRecord;
    }


    public CheckApply getCheckApplyById(Integer id, ResultMessage resultMessage){
        CheckApply checkApply=checkApplyMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(checkApply!=null){
            return checkApply;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.EXAMINATION_TEST_DISPOSAL_NOT_EXIST);
            return null;
        }

    }


    public CheckApply addCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        try {
            checkApplyMapper.insert(checkApply);
            return checkApply;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public CheckApply updateCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        getCheckApplyById(checkApply.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                checkApplyMapper.updateByPrimaryKey(checkApply);
                return getCheckApplyById(checkApply.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
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
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public Prescription addPrescription(Prescription prescription, ResultMessage resultMessage){
        try {
            prescriptionMapper.insert(prescription);
            return prescription;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public Prescription getPrescriptionById(Integer id, ResultMessage resultMessage){
        Prescription prescription=prescriptionMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(prescription!=null){
            return prescription;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.PRESCRIPTION_NOT_EXIST);
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
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public CheckDetailed addCheckDetailed(CheckDetailed checkDetailed,ResultMessage resultMessage){
        try {
            checkDetailedMapper.insert(checkDetailed);
            return checkDetailed;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public CheckDetailed getCheckDetailedById(Integer id, ResultMessage resultMessage){
        CheckDetailed checkDetailed=checkDetailedMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(checkDetailed!=null){
            return checkDetailed;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.EXAMINATION_TEST_DISPOSAL_DETAIL_NOT_EXIST);
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
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


    public PrescriptionDetailed addPrescriptionDetailed(PrescriptionDetailed prescriptionDetailed,ResultMessage resultMessage){
        try {
            prescriptionDetailedMapper.insert(prescriptionDetailed);
            return prescriptionDetailed;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public PrescriptionDetailed getPrescriptionDetailedById(Integer id, ResultMessage resultMessage){
        PrescriptionDetailed prescriptionDetailed=prescriptionDetailedMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(prescriptionDetailed!=null){
            return prescriptionDetailed;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.PRESCRIPTION_DETAIL_NOT_EXIST);
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
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }









}
