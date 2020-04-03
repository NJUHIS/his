package com.njuhis.his.service;

import com.njuhis.his.mapper.PatientMapper;
import com.njuhis.his.mapper.UserMapper;
import com.njuhis.his.model.Invoice;
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

    public User updateUser(User user, ResultMessage resultMessage){
        getUserById(user.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                userMapper.updateByPrimaryKey(user);
                return getUserById(user.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

    public Patient getPatientById(Integer id, ResultMessage resultMessage){
        Patient patient=null;
        //TODO
        //Patient patient=patientMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(patient!=null){
            return patient;
        }else{
            resultMessage.setClientError(ResultMessage.INVOICE_NOT_EXIST);
            return null;
        }

    }


    public Patient updatePatient(Patient patient, ResultMessage resultMessage){
        getPatientById(patient.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                //patientMapper.updateByPrimaryKey(patient);
                //TODO
                return getPatientById(patient.getId(),resultMessage);
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
