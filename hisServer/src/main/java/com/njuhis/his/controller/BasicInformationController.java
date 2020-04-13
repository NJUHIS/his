package com.njuhis.his.controller;

import com.github.pagehelper.PageInfo;
import com.njuhis.his.model.*;
import com.njuhis.his.service.BasicInformationService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private QuickLogger quickLogger = new QuickLogger(this.getClass());

    /**
     * 獲取所有的科室
     *
     * @param httpServletResponse
     * @return
     */
    
    @RequestMapping(value = "/getAllDepartments")
    public List<Department> getAllDepartments(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        List<Department> departments = basicInformationService.getAllDepartments(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(departments);
        return departments;
    }


    /**
     * 新增一名用户
     *
     * @param user user 的 id 會從無到有
     */
    @RequestMapping(value = "/addUser")
    public User addDoctor(@RequestBody User user, HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        quickLogger.logReceive(user);
        ResultMessage resultMessage = new ResultMessage(httpServletResponse);

        User result = basicInformationService.addUser(user, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    /**
     * 獲取特定預約日期之間的醫院員工
     * @param startDate
     * @param endDate
     * @param pageNumber
     * @param pageSize
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "/getUsersBetweenScheduleDates")
    public List<User> getUsersBetweenScheduleDates(@RequestParam Long startDate, @RequestParam Long endDate, @RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "0") int pageSize, HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        quickLogger.logReceive(startDate);
        quickLogger.logReceive(endDate);
        quickLogger.logReceive(pageNumber);
        quickLogger.logReceive(pageSize);
        ResultMessage resultMessage = new ResultMessage(httpServletResponse);

        List<User> result = basicInformationService.getUsersBetweenScheduleDates(startDate, endDate,pageNumber,pageSize, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    /**
     * 獲取特定預約日期之間的患者
     * @param startDate
     * @param endDate
     * @param pageNumber
     * @param pageSize
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "/getPatientsBetweenScheduleDates")
    public List<Patient> getPatientsBetweenScheduleDates(@RequestParam Long startDate, @RequestParam Long endDate, @RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "0") int pageSize, HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        quickLogger.logReceive("startDate",startDate);
        quickLogger.logReceive("endDate",endDate);
        quickLogger.logReceive("pageNumber",pageNumber);
        quickLogger.logReceive("pageSize",pageSize);
        ResultMessage resultMessage = new ResultMessage(httpServletResponse);

        List<Patient> result = basicInformationService.getPatientsBetweenScheduleDates(startDate, endDate, pageNumber, pageSize, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(department);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Department result=basicInformationService.addDepartment(department, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getDepartmentById")
    public Department getInvoiceById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Department result=basicInformationService.getDepartmentById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/updateDepartment")
    public Department updateInvoice(@RequestBody Department department,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(department);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Department result=basicInformationService.updateDepartment(department, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }



    @RequestMapping(value = "/getAllConstantItems")
    public List<ConstantItem> getAllConstantItems(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        List<ConstantItem> result = basicInformationService.getAllConstantItems(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/addConstantItem")
    public ConstantItem addConstantItem(@RequestBody ConstantItem constantItem, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(constantItem);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantItem result=basicInformationService.addConstantItem(constantItem, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }



    @RequestMapping("/getConstantItemById")
    public ConstantItem getConstantItemById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantItem result=basicInformationService.getConstantItemById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }




    @RequestMapping("/updateConstantItem")
    public ConstantItem updateConstantItem(@RequestBody ConstantItem constantItem, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(constantItem);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantItem result=basicInformationService.updateConstantItem(constantItem, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }



    //TODO 待测试
    @RequestMapping(value = "/getAllConstantTypes")
    public List<ConstantType> getAllConstantTypes(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        List<ConstantType> result = basicInformationService.getAllConstantTypes(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addConstantType")
    public ConstantType addConstantType(@RequestBody ConstantType constantType, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(constantType);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantType result=basicInformationService.addConstantType(constantType, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待测试

    @RequestMapping("/getConstantTypeById")
    public ConstantType getConstantTypeById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantType result=basicInformationService.getConstantTypeById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待测试

    @RequestMapping("/updateConstantType")
    public ConstantType updateConstantType(@RequestBody ConstantType constantType,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(constantType);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantType result=basicInformationService.updateConstantType(constantType, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }






    @RequestMapping(value = "/getAllRegisterLevels")
    public List<RegisterLevel> getAllRegisterLevels(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        List<RegisterLevel> result = basicInformationService.getAllRegisterLevels(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addRegisterLevel")
    public RegisterLevel addRegisterLevel(@RequestBody RegisterLevel registerLevel, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(registerLevel);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        RegisterLevel result=basicInformationService.addRegisterLevel(registerLevel, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待测试

    @RequestMapping("/getRegisterLevelById")
    public RegisterLevel getRegisterLevelById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        RegisterLevel result=basicInformationService.getRegisterLevelById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待测试

    @RequestMapping("/updateRegisterLevel")
    public RegisterLevel updateRegisterLevel(@RequestBody RegisterLevel registerLevel,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(registerLevel);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        RegisterLevel result=basicInformationService.updateRegisterLevel(registerLevel, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    //TODO 待测试
    @RequestMapping(value = "/getAllSettleCategories")
    public List<SettleCategory> getAllSettleCategories(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoked();
        List<SettleCategory> result = basicInformationService.getAllSettleCategories(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addSettleCategory")
    public SettleCategory addSettleCategory(@RequestBody SettleCategory settleCategory, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(settleCategory);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        SettleCategory result=basicInformationService.addSettleCategory(settleCategory, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待测试

    @RequestMapping("/getSettleCategoryById")
    public SettleCategory getSettleCategoryById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        SettleCategory result=basicInformationService.getSettleCategoryById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待测试

    @RequestMapping("/updateSettleCategory")
    public SettleCategory updateSettleCategory(@RequestBody SettleCategory settleCategory,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(settleCategory);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        SettleCategory result=basicInformationService.updateSettleCategory(settleCategory, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }








}


