package com.njuhis.his.controller;

import com.github.pagehelper.PageInfo;
import com.njuhis.his.model.*;
import com.njuhis.his.service.AdministrationService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping("/dep")
    public List<DepartmentVo> getDepartmentAndDoctor(HttpServletResponse httpServletResponse){
        return administrationService.getDepartmentAndDoctor();
    }

    public List<CostVo> getReceivableAccounts(@RequestParam Integer startTime, @RequestParam Integer endTime,HttpServletResponse httpServletResponse){
        return administrationService.getReceivableAccounts(startTime,endTime);
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

    public List<CostVo> getReceivedAccounts(@RequestParam Integer startTime, @RequestParam Integer endTime,HttpServletResponse httpServletResponse){
        return administrationService.getReceivedAccounts(startTime,endTime);
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

    public List<PatientVo> getPatAccount(@RequestParam Integer startTime, @RequestParam Integer endTime,HttpServletResponse httpServletResponse){
        return null;
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

    public PageInfo<PatientCosts> getPatientCostList(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        return null;
    }
    public PageInfo<CheckDetailed> getCheckDetailedList(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        return null;
    }
    public PageInfo<Register> getRegisterList(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        return null;
    }
}
