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


    @RequestMapping("/updateUser")
    public User updateInvoice(@RequestBody User user, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(user);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        User result=personalInformationService.updateUser(user, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/userSignIn")
    public User userSignIn(@RequestParam String username, @RequestParam String password,HttpServletResponse httpServletResponse ){
        quickLogger.logInvoked();
        quickLogger.logReceive("username",username);
        quickLogger.logReceive("password",password);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        User user=personalInformationService.userSignIn(username,password,resultMessage);

        quickLogger.logReturn(user);
        return user;
    }

    //TODO 待測試
    @RequestMapping("/getPatientById")
    public Patient getIPatientById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Patient result=personalInformationService.getPatientById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待測試
    @RequestMapping("/updatePatient")
    public Patient updateInvoice(@RequestBody Patient patient,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(patient);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Patient result=personalInformationService.updatePatient(patient, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }







}
