package com.njuhis.his.service;

import com.njuhis.his.mapper.PatientMapper;
import com.njuhis.his.mapper.UserMapper;
import com.njuhis.his.model.Patient;
import com.njuhis.his.model.User;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Autowired
    private UtilityService utilityService;

    public Patient addPatient(Patient patient, ResultMessage resultMessage){

        //确保用户名不存在。
        makeSurePatientUsernameNotExist(patient.getLoginname(),resultMessage);if(!resultMessage.isSuccessful()) return null;//异常流程。用户名已存在。返回。

        try {
            patientMapper.insert(patient);
        }catch (DataIntegrityViolationException exception) {
            utilityService.dealDataIntegrityViolationException(resultMessage, exception);
            return null;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.sendUnknownError();
            return null;
        }
        return getPatientById(patient.getId(),resultMessage);
    }

    public User getUserById(Integer id, ResultMessage resultMessage){
        User user=userMapper.selectByPrimaryKey(id);
        if(user==null) resultMessage.sendClientError(ResultMessage.ErrorMessage.USER_NOT_EXIST); //异常流程
        return user;
    }

    public User getUserByUsername(String username, ResultMessage resultMessage){
        User user=userMapper.selectByUserName(username);
        if(user==null) resultMessage.sendClientError(ResultMessage.ErrorMessage.USER_NOT_EXIST); //异常流程
        return user;
    }

    public Patient getPatientByUsername(String username, ResultMessage resultMessage){
        Patient patient=patientMapper.selectByLoginName(username);
        if(patient==null) resultMessage.sendClientError(ResultMessage.ErrorMessage.PATIENT_NOT_EXIST); //异常流程
        return patient;
    }

    public User updateUser(User user, ResultMessage resultMessage){
        getUserById(user.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                userMapper.updateByPrimaryKey(user);
                return getUserById(user.getId(),resultMessage);
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

    public User userSignIn(String username, String password, ResultMessage resultMessage){
        User user=getUserByUsername(username,resultMessage);
        if(!resultMessage.isSuccessful()) return null;//异常流程返回

        if(user.getPassword().equals(password)){//密码正确
            return user;

        }else{//密码错误，异常流程
            resultMessage.sendClientError(ResultMessage.ErrorMessage.INCORRECT_PASSWORD);
            return null;
        }

    }

    public Patient patientSignIn(String username, String password, ResultMessage resultMessage){
        Patient patient=getPatientByUsername(username,resultMessage);
        if(!resultMessage.isSuccessful()) return null;//异常流程返回

        if(patient.getPassword().equals(password)){//密码正确
            return patient;

        }else{//密码错误，异常流程
            resultMessage.sendClientError(ResultMessage.ErrorMessage.INCORRECT_PASSWORD);
            return null;
        }

    }

    public Patient getPatientById(Integer id, ResultMessage resultMessage){

        Patient patient=patientMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(patient!=null){
            return patient;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.PATIENT_NOT_EXIST);
            return null;
        }

    }



    public Patient updatePatient(Patient patient, ResultMessage resultMessage){
        getPatientById(patient.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                patientMapper.updateByPrimaryKey(patient);
                return getPatientById(patient.getId(),resultMessage);
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

    public boolean ifPatientIdExist(Integer patientId){
        Patient patient=patientMapper.selectByPrimaryKey(patientId);//如果失败，并不会抛出异常，只会返回null。
        if(patient!=null){
            return true;
        }else{
            return false;
        }
    }

    public boolean ifPatientUsernameExist(String patientUsername){
        Patient patient=patientMapper.selectByLoginName(patientUsername);//如果失败，并不会抛出异常，只会返回null。
        if(patient!=null){
            return true;
        }else{
            return false;
        }
    }

    public ResultMessage makeSurePatientUsernameNotExist(String patientUsername, ResultMessage resultMessage){
        if(!ifPatientUsernameExist(patientUsername)){
            return resultMessage;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.PATIENT_USERNAME_EXISTED);
            return resultMessage;
        }
    }

    public boolean ifUserIdExist(Integer userId){
        User user=userMapper.selectByPrimaryKey(userId);//如果失败，并不会抛出异常，只会返回null。
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    public boolean ifUserUsernameExist(String userUsername){
        User user=userMapper.selectByUserName(userUsername);//如果失败，并不会抛出异常，只会返回null。
        if(user!=null){
            return true;
        }else{
            return false;
        }
    }

    public ResultMessage makeSureUserUsernameNotExist(String userUsername, ResultMessage resultMessage){
        if(!ifUserUsernameExist(userUsername)){
            return resultMessage;
        }else{
            resultMessage.sendClientError(ResultMessage.ErrorMessage.WORKER_USERNAME_EXISTED);
            return resultMessage;
        }
    }









}
