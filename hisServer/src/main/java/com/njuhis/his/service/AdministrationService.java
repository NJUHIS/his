package com.njuhis.his.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.mapper.PatientCostsMapper;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdministrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    @Autowired
    DepartmentMapper departmentMapper;

    public List<DepartmentVo> getDepartmentAndDoctor(ResultMessage resultMessage){

        List<Department> departments=new ArrayList<>();
        departments=departmentMapper.selectAllJoin();
        List<DepartmentVo> list=new ArrayList<>();
        DepartmentVo departmentVo1=new DepartmentVo();
        DepartmentVo departmentVo2=new DepartmentVo();
        DepartmentVo departmentVo3=new DepartmentVo();
        DepartmentVo departmentVo4=new DepartmentVo();
        departmentVo1.setDepartmentList(new ArrayList<>());
        departmentVo2.setDepartmentList(new ArrayList<>());
        departmentVo3.setDepartmentList(new ArrayList<>());
        departmentVo4.setDepartmentList(new ArrayList<>());
        departmentVo1.setTypeName("门诊科室");
        departmentVo2.setTypeName("医技科室");
        departmentVo3.setTypeName("行政科室");
        departmentVo4.setTypeName("后勤科室");
        for (Department d:departments){
            System.out.println(d.getId());
            switch (d.getDepttypeid()) {
                case 1 : departmentVo1.getDepartmentList().add(d);
                    break;
                case 2 : departmentVo2.getDepartmentList().add(d);
                    break;
                case 3 : departmentVo3.getDepartmentList().add(d);
                    break;
                case 4 : departmentVo4.getDepartmentList().add(d);
                    break;
            }
        }
        list.add(departmentVo1);
        list.add(departmentVo2);
        list.add(departmentVo3);
        list.add(departmentVo4);
        return list;
    }

    public List<CostVo> getReceivableAccounts(int startTime,int endTime,ResultMessage resultMessage){

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

    public List<CostVo> getReceivedAccounts(int startTime,int endTime){
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


    @Autowired
    PatientCostsMapper patientCostsMapper;
    public PageInfo<PatientCosts> getPatientCostList(Integer currPage,PatientCosts patientCosts){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, 8);
        PageInfo<PatientCosts> pageInfo = new PageInfo<>(patientCostsMapper.selectByConditions(patientCosts));
        return pageInfo;
    }

    public PageInfo<CheckDetailed> getCheckDetailedList(CheckDetailed checkDetailed){
        return null;
    }
    public PageInfo<Register> getRegisterList(Register register){

        return null;
    }
}
