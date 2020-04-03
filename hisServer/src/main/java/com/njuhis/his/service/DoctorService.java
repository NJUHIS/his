package com.njuhis.his.service;

import com.njuhis.his.mapper.CheckApplyMapper;
import com.njuhis.his.mapper.MedicalRecordMapper;
import com.njuhis.his.model.CheckApply;
import com.njuhis.his.model.Invoice;
import com.njuhis.his.model.MedicalRecord;
import com.njuhis.his.model.Register;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
//import com.sun.tools.javac.comp.Check;
import com.sun.tools.javac.comp.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class DoctorService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private MedicalRecordMapper medicalRecordMapper;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private CheckApplyMapper checkApplyMapper;
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
            resultMessage.setClientError(ResultMessage.MEDICAL_CARD_NOT_EXIST);
        }
        return medicalRecord;
    }


    public CheckApply getCheckApplyById(Integer id, ResultMessage resultMessage){
        CheckApply checkApply=checkApplyMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(checkApply!=null){
            return checkApply;
        }else{
            resultMessage.setClientError(ResultMessage.EXAMINATION_TEST_DISPOSAL_NOT_EXIST);
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





}
