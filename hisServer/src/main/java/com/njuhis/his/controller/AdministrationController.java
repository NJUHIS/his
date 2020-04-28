package com.njuhis.his.controller;

import com.github.pagehelper.PageInfo;
import com.njuhis.his.model.*;
import com.njuhis.his.service.AdministrationService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

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

    private List<CostVo> getReceivableAccounts(){
        return null;
    };
    private List<CostVo> getReceivableAccountsByDays(){
        return null;
    };
    private List<CostVo> getReceivableAccountsByWeeks(){
        return null;
    };
    private List<CostVo> getReceivableAccountsByMonths(){
        return null;
    };


    private List<CostVo> getReceivedAccounts(){
        return null;
    };
    private List<CostVo> getReceivedAccountsByDays(){
        return null;
    };
    private List<CostVo> getReceivedAccountsByWeeks(){
        return null;
    };
    private List<CostVo> getReceivedAccountsByMonths(){
        return null;
    };


    private List<DepartmentVo> getDepartmentAndDoctor(){
        return administrationService.getDepartmentAndDoctor();
    }



    private List<PatientVo> getPatAccount(){
        return null;
    }
    private List<PatientVo> getPatAccountByDays(){
        return null;
    }
    private List<PatientVo> getPatAccountByWeeks(){
        return null;
    }
    private List<PatientVo> getPatAccountByMonths(){
        return null;
    }

    private PageInfo<PatientCosts> getPatientCostList(@PathVariable Integer currPage, @RequestBody PatientCosts patientCosts){
        return null;
    }
    private PageInfo<CheckDetailed> getCheckDetailedList(@PathVariable Integer currPage, @RequestBody CheckDetailed checkDetailed){
        return null;
    }
    private PageInfo<Register> getRegisterList(@PathVariable Integer currPage, @RequestBody Register register){
        return null;
    }
}
