package com.njuhis.his.controller;

import com.njuhis.his.model.*;
import com.njuhis.his.service.BasicInformationService;
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
     * 獲取所有的科室
     *
     * @param httpServletResponse
     * @return
     */
    
    @RequestMapping(value = "/getAllDepartments")
    public List<Department> getAllDepartments(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
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
        quickLogger.logInvoke();
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
        quickLogger.logInvoke();
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
        quickLogger.logInvoke();
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
        quickLogger.logInvoke();
        quickLogger.logReceive(department);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Department result=basicInformationService.addDepartment(department, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getDepartmentById")
    public Department getInvoiceById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Department result=basicInformationService.getDepartmentById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/updateDepartment")
    public Department updateInvoice(@RequestBody Department department,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(department);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Department result=basicInformationService.updateDepartment(department, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }



    @RequestMapping(value = "/getAllConstantItems")
    public List<ConstantItem> getAllConstantItems(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<ConstantItem> result = basicInformationService.getAllConstantItems(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/addConstantItem")
    public ConstantItem addConstantItem(@RequestBody ConstantItem constantItem, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(constantItem);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantItem result=basicInformationService.addConstantItem(constantItem, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }



    @RequestMapping("/getConstantItemById")
    public ConstantItem getConstantItemById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantItem result=basicInformationService.getConstantItemById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }




    @RequestMapping("/updateConstantItem")
    public ConstantItem updateConstantItem(@RequestBody ConstantItem constantItem, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(constantItem);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantItem result=basicInformationService.updateConstantItem(constantItem, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }




    @RequestMapping(value = "/getAllConstantTypes")
    public List<ConstantType> getAllConstantTypes(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<ConstantType> result = basicInformationService.getAllConstantTypes(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/addConstantType")
    public ConstantType addConstantType(@RequestBody ConstantType constantType, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(constantType);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantType result=basicInformationService.addConstantType(constantType, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    @RequestMapping("/getConstantTypeById")
    public ConstantType getConstantTypeById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantType result=basicInformationService.getConstantTypeById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }



    @RequestMapping("/updateConstantType")
    public ConstantType updateConstantType(@RequestBody ConstantType constantType,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(constantType);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ConstantType result=basicInformationService.updateConstantType(constantType, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }






    @RequestMapping(value = "/getAllRegisterLevels")
    public List<RegisterLevel> getAllRegisterLevels(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<RegisterLevel> result = basicInformationService.getAllRegisterLevels(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/addRegisterLevel")
    public RegisterLevel addRegisterLevel(@RequestBody RegisterLevel registerLevel, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(registerLevel);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        RegisterLevel result=basicInformationService.addRegisterLevel(registerLevel, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }



    @RequestMapping("/getRegisterLevelById")
    public RegisterLevel getRegisterLevelById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        RegisterLevel result=basicInformationService.getRegisterLevelById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }




    @RequestMapping("/updateRegisterLevel")
    public RegisterLevel updateRegisterLevel(@RequestBody RegisterLevel registerLevel,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(registerLevel);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        RegisterLevel result=basicInformationService.updateRegisterLevel(registerLevel, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    //TODO 待测试
    @RequestMapping(value = "/getAllSettleCategories")
    public List<SettleCategory> getAllSettleCategories(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<SettleCategory> result = basicInformationService.getAllSettleCategories(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addSettleCategory")
    public SettleCategory addSettleCategory(@RequestBody SettleCategory settleCategory, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(settleCategory);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        SettleCategory result=basicInformationService.addSettleCategory(settleCategory, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待测试

    @RequestMapping("/getSettleCategoryById")
    public SettleCategory getSettleCategoryById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        SettleCategory result=basicInformationService.getSettleCategoryById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待测试

    @RequestMapping("/updateSettleCategory")
    public SettleCategory updateSettleCategory(@RequestBody SettleCategory settleCategory,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(settleCategory);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        SettleCategory result=basicInformationService.updateSettleCategory(settleCategory, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


        //TODO 待测试
    @RequestMapping(value = "/getAllExpenseClasses")
    public List<ExpenseClass> getAllExpenseClasses(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<ExpenseClass> result = basicInformationService.getAllExpenseClasses(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addExpenseClass")
    public ExpenseClass addExpenseClass(@RequestBody ExpenseClass expenseClass, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(expenseClass);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ExpenseClass result=basicInformationService.addExpenseClass(expenseClass, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待测试

    @RequestMapping("/getExpenseClassById")
    public ExpenseClass getExpenseClassById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ExpenseClass result=basicInformationService.getExpenseClassById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待测试

    @RequestMapping("/updateExpenseClass")
    public ExpenseClass updateExpenseClass(@RequestBody ExpenseClass expenseClass,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(expenseClass);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        ExpenseClass result=basicInformationService.updateExpenseClass(expenseClass, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    //TODO 待测试
    @RequestMapping(value = "/getAllSchedulings")
    public List<Scheduling> getAllSchedulings(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<Scheduling> result = basicInformationService.getAllSchedulings(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addScheduling")
    public Scheduling addScheduling(@RequestBody Scheduling scheduling, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(scheduling);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Scheduling result=basicInformationService.addScheduling(scheduling, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待测试

    @RequestMapping("/getSchedulingById")
    public Scheduling getSchedulingById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Scheduling result=basicInformationService.getSchedulingById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待测试

    @RequestMapping("/updateScheduling")
    public Scheduling updateScheduling(@RequestBody Scheduling scheduling,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(scheduling);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Scheduling result=basicInformationService.updateScheduling(scheduling, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    @RequestMapping("/getSchedulingsByConditions")
    public List<Scheduling> getSchedulingsByConditions(@RequestParam(required = false) Date fromScheduleDate,
                                                       @RequestParam(required = false) Integer fromNoon,
                                                       @RequestParam(required = false) Date toScheduleDate,
                                                       @RequestParam(required = false) Integer toNoon,
                                                       @RequestParam(required = false) Integer deptId,
                                                       @RequestParam(required = false) Integer userId,
                                                       @RequestParam(required = false) Integer state,
                                                       HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        quickLogger.logReceive("fromScheduleDate",fromScheduleDate,
                "fromNoon",fromNoon,
                "toScheduleDate",toScheduleDate,
                "toNoon",toNoon,
                "deptId",deptId,
                "userId",userId,
                "state",state
        );
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        List<Scheduling> result=basicInformationService.getSchedulingsByConditions(fromScheduleDate,fromNoon,toScheduleDate,toNoon,deptId,userId,state,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }



}


