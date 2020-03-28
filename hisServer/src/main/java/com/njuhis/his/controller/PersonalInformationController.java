package com.njuhis.his.controller;

import com.njuhis.his.model.Patient;
import com.njuhis.his.model.User;
import com.njuhis.his.service.PersonalInformationService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Paul
 * 个人信息管理
 * 个人信息数据修改维护
 */
@RestController
@RequestMapping("/PersonalInformationController")
public class PersonalInformationController {
    @Autowired
    private PersonalInformationService personalInformationService;
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

        Patient result =personalInformationService.addPatient(patient,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/getUserById")
    public User getUserById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        User result=personalInformationService.getUserById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }
}
