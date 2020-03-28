package com.njuhis.his.service;

import com.njuhis.his.mapper.CheckApplyMapper;
import com.njuhis.his.mapper.MedicalRecordMapper;
import com.njuhis.his.model.CheckApply;
import com.njuhis.his.model.MedicalRecord;
import com.njuhis.his.model.Register;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
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
}
