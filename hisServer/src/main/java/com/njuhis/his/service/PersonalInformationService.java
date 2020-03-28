package com.njuhis.his.service;

import com.njuhis.his.mapper.PatientMapper;
import com.njuhis.his.mapper.UserMapper;
import com.njuhis.his.model.Patient;
import com.njuhis.his.model.User;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 */
@Service
public class PersonalInformationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private UserMapper userMapper;

    public Patient addPatient(Patient patient, ResultMessage resultMessage){
        try {
            patientMapper.insert(patient);
            return patient;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public User getUserById(Integer id, ResultMessage resultMessage){
        User user=userMapper.selectByPrimaryKey(id);
        if(user==null) resultMessage.setClientError(ResultMessage.USER_NOT_EXIST);
        return user;
    }
}
