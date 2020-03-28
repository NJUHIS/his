package com.njuhis.his.controller;

import com.njuhis.his.model.Patient;
import com.njuhis.his.service.PersonalInfoService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * @author Paul
 * 个人信息管理
 * 个人信息数据修改维护
 */
@RestController
@RequestMapping("personalInfo")
public class PersonalInfomationController {
    @Autowired
    private PersonalInfoService personalInfoService;
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    /**
     * 新增/註冊一名患者
     * @param patient
     * @param httpServletResponse
     * @return
     *
     */
    @RequestMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(patient);

        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        personalInfoService.addPatient(patient,resultMessage);

        Patient result=patient;
        if(!resultMessage.isSuccessful()){
            result=null;
        }
        quickLogger.logReturn(result);
        return result;
    }
}
