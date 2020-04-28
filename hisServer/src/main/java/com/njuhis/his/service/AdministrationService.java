package com.njuhis.his.service;

import com.github.pagehelper.PageInfo;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());



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
