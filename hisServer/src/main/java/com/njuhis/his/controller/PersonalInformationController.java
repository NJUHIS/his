package com.njuhis.his.controller;

import com.njuhis.his.model.Patient;
import com.njuhis.his.model.User;
import com.njuhis.his.service.PersonalInformationService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * 这个函数使得這個 Controller 可以把 yyyy-MM-dd 的 String RequestParam 轉化為 Date 類型
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


    /**
     * 新增/註冊一名患者
     * @param patient
     * @param httpServletResponse
     * @return
     *
     */
    @RequestMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(patient);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Patient result =personalInformationService.addPatient(patient,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/getUserById")
    public User getUserById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        User result=personalInformationService.getUserById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/updateUser")
    public User updateInvoice(@RequestBody User user, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(user);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        User result=personalInformationService.updateUser(user, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/userSignIn")
    public User userSignIn(@RequestParam String username, @RequestParam String password,HttpServletResponse httpServletResponse ){
        quickLogger.logInvoke();
        quickLogger.logReceive("username",username);
        quickLogger.logReceive("password",password);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        User user=personalInformationService.userSignIn(username,password,resultMessage);

        quickLogger.logReturn(user);
        return user;
    }

    @RequestMapping("patientSignIn")
    public Patient patient(@RequestParam String username, @RequestParam String password, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive("username",username);
        quickLogger.logReceive("password",password);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Patient patient=personalInformationService.patientSignIn(username,password,resultMessage);

        quickLogger.logReturn(patient);
        return patient;
    }


    @RequestMapping("/getPatientById")
    public Patient getIPatientById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Patient result=personalInformationService.getPatientById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }



    @RequestMapping("/updatePatient")
    public Patient updateInvoice(@RequestBody Patient patient,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(patient);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Patient result=personalInformationService.updatePatient(patient, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }







}
