package com.njuhis.his.service;

import com.njuhis.his.mapper.PatientMapper;
import com.njuhis.his.model.Patient;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoService {
    @Autowired
    private PatientMapper patientMapper;
    public void addPatient(Patient patient, ResultMessage resultMessage){
        try {
            patientMapper.insert(patient);
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
        }
    }
}
