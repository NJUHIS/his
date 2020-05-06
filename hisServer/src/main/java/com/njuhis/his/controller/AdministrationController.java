package com.njuhis.his.controller;

import com.github.pagehelper.PageInfo;
import com.njuhis.his.model.*;
import com.njuhis.his.service.AdministrationService;
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
 * 医院行政管理
 * 医院统计信息查看管理
 */
@RestController
@RequestMapping("/AdministrationController")
public class AdministrationController {
    @Autowired
    private AdministrationService administrationService;
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



    @RequestMapping("/getDepartmentAndDoctor")
    public List<DepartmentVo> getDepartmentAndDoctor(HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        List<DepartmentVo> res= administrationService.getDepartmentAndDoctor(resultMessage);
        quickLogger.logReturn(res);
        return res;
    }
    @RequestMapping("/getReceivableAccounts")
    public List<CostVo> getReceivableAccounts(@RequestBody CostVo costVo, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        System.out.println(costVo.getBegintime());
        Long startTime = costVo.getBegintime();
        Long endTime = costVo.getEndtime();
        quickLogger.logReceive(startTime);
        quickLogger.logReceive(endTime);

        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        List<CostVo> res = administrationService.getReceivableAccounts(startTime,endTime,resultMessage);
        quickLogger.logReturn(res);
        return res;
    };
    public List<CostVo> getReceivableAccountsByDays(@RequestParam Integer id,HttpServletResponse httpServletResponse){
        return administrationService.getReceivableAccountsByDays();
    };
    public List<CostVo> getReceivableAccountsByWeeks(@RequestParam Integer id,HttpServletResponse httpServletResponse){
        return administrationService.getReceivableAccountsByWeeks();
    };
    public List<CostVo> getReceivableAccountsByMonths(@RequestParam Integer id,HttpServletResponse httpServletResponse){
        return administrationService.getReceivableAccountsByMonths();
    };
    @RequestMapping("/getReceivedAccounts")
    public List<CostVo> getReceivedAccounts(@RequestBody CostVo costVo, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        System.out.println(costVo.getBegintime());
        Long startTime = costVo.getBegintime();
        Long endTime = costVo.getEndtime();
        quickLogger.logReceive(startTime);
        quickLogger.logReceive(endTime);

        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        List<CostVo> res = administrationService.getReceivedAccounts(startTime,endTime,resultMessage);
        quickLogger.logReturn(res);
        return res;
    };
    public List<CostVo> getReceivedAccountsByDays(@RequestParam Integer id,HttpServletResponse httpServletResponse){
        return administrationService.getReceivedAccountsByDays();
    };
    public List<CostVo> getReceivedAccountsByWeeks(@RequestParam Integer id,HttpServletResponse httpServletResponse){
        return administrationService.getReceivedAccountsByWeeks();
    };
    public List<CostVo> getReceivedAccountsByMonths(@RequestParam Integer id,HttpServletResponse httpServletResponse){
        return administrationService.getReceivedAccountsByMonths();
    };
    @RequestMapping("/getPatAccounts")
    public List<PatientVo> getPatAccount(@RequestBody PatientVo patientVo, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(patientVo.getBegintime());
        quickLogger.logReceive(patientVo.getEndtime());
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        List<PatientVo> res =administrationService.getPatAccount(patientVo.getBegintime(),patientVo.getEndtime(),resultMessage);
        quickLogger.logReturn(res);
        return res;
    }
    public List<PatientVo> getPatAccountByDays(){
        return null;
    }
    public List<PatientVo> getPatAccountByWeeks(){
        return null;
    }
    public List<PatientVo> getPatAccountByMonths(){
        return null;
    }

    public PageInfo<PatientCosts> getPatientCostList(@RequestParam Integer currPage, @RequestParam String conditions,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(currPage);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        PageInfo<PatientCosts> res = administrationService.getPatientCostList(currPage,conditions);
        quickLogger.logReturn(res);
        return res;
    }
    public PageInfo<CheckDetailed> getCheckDetailedList(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        return null;
    }
    @RequestMapping("/Register")
    public PageInfo<Register> getRegisterList(@RequestParam Integer currPage, @RequestParam String conditions,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(currPage);
        quickLogger.logReceive(conditions);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);
        PageInfo<Register> res = administrationService.getRegisterList(currPage,conditions);
        quickLogger.logReturn(res);
        return res;
    }
}
