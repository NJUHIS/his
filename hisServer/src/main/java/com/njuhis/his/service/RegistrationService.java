package com.njuhis.his.service;

import com.njuhis.his.mapper.RegisterMapper;
import com.njuhis.his.model.Register;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    @Autowired
    private RegisterMapper registerMapper;


    public Register addRegistration(Register registration, ResultMessage resultMessage){
        try{
            registerMapper.insert(registration);
            return registration;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public Register getRegistrationById(Integer id, ResultMessage resultMessage){
        Register registration=registerMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(registration!=null){
            return registration;
        }else{
            resultMessage.setClientError(ResultMessage.REGISTRATION_NOT_EXIST);
            return null;
        }

    }

    public Register updateRegistration(Register registration, ResultMessage resultMessage){
        try{
            registerMapper.updateByPrimaryKey(registration);
            return registration;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

}
