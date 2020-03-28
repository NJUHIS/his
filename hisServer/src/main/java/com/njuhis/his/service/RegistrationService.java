package com.njuhis.his.service;

import com.njuhis.his.mapper.RegisterMapper;
import com.njuhis.his.model.Register;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ResourceBundle;

@Service
public class RegistrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    @Autowired
    private RegisterMapper registerMapper;


    public void addRegistration(Register registration, ResultMessage resultMessage){
        try{
            registerMapper.insert(registration);
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
        }
    }
}
