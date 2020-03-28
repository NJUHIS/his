package com.njuhis.his.controller;

import com.njuhis.his.model.Department;
import com.njuhis.his.model.User;
import com.njuhis.his.service.BasicInformationService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Paul
 * 基础信息管理
 * 医院系统管理数据维护
 */
@RequestMapping("/BasicInformationController")
@RestController
public class BasicInformationController {
    @Autowired
    private BasicInformationService basicInformationService;
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    /**
     * 獲取所有的科室
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "/getAllDepartments")
    public List<Department> getAllDepartments(HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        List<Department> departments= basicInformationService.getAllDepartments(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(departments);
        return departments;
    }


    /**
     * 新增一名用户
     * @param user
     * user 的 id 會從無到有
     */
    @RequestMapping(value = "/addUser")
    public User addDoctor(@RequestBody User user, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(user);

        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        basicInformationService.addUser(user,resultMessage);

        User result = user;
        if(!resultMessage.isSuccessful()) {
            result=null;
        }

        quickLogger.logReturn(result);
        return result;
    }



}


