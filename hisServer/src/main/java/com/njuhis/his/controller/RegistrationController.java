package com.njuhis.his.controller;

import com.njuhis.his.model.Register;
import com.njuhis.his.service.RegistrationService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Paul
 * 门诊挂号收费
 * 门诊挂号收费数据管理
 */
@RestController
@RequestMapping("/RegistrationController")
public class RegistrationController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private RegistrationService registrationService;


    @RequestMapping("/addRegistration")
    public Register addRegistration(@RequestBody Register registration, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(registration);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Register result=registrationService.addRegistration(registration,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


}



