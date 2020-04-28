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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

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
    public List<DepartmentVo> getDepartmentAndDoctor(){
        return null;
    }

    public List<CostVo> getReceivableAccounts(){
        return null;
    };
    public List<CostVo> getReceivableAccountsByDays(){
        return null;
    };
    public List<CostVo> getReceivableAccountsByWeeks(){
        return null;
    };
    public List<CostVo> getReceivableAccountsByMonths(){
        return null;
    };

    public List<CostVo> getReceivedAccounts(){
        return null;
    };
    public List<CostVo> getReceivedAccountsByDays(){
        return null;
    };
    public List<CostVo> getReceivedAccountsByWeeks(){
        return null;
    };
    public List<CostVo> getReceivedAccountsByMonths(){
        return null;
    };

    public List<PatientVo> getPatAccount(){
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

    public PageInfo<PatientCosts> getPatientCostList(){
        return null;
    }
    public PageInfo<CheckDetailed> getCheckDetailedList(){
        return null;
    }
    public PageInfo<Register> getRegisterList(){
        return null;
    }
}
