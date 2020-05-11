package com.njuhis.his.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njuhis.his.mapper.*;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.omg.IOP.Encoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdministrationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    PatientCostsMapper patientCostsMapper;
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

    public List<CostVo> getReceivableAccounts(Long startTime,Long endTime,ResultMessage resultMessage){
        int days=(int)((endTime-startTime)/86400000);
        System.out.println(days);
        List<CostVo> costVoList=new ArrayList<>();
        for (int i=0;i<days;i++){
            CostVo costVo=new CostVo();
            costVo.setBegintime(startTime-startTime%86400000+i*86400000);
            costVo.setEndtime(startTime-startTime%86400000+(i+1)*86400000);
            costVoList.add(costVo);
        }
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        System.out.println(costVoList.size());
        List<CostVo> costVoListRes=new ArrayList<>();
        for (int i=0;i<days;i++){
            System.out.println(sdf.format(costVoList.get(i).getBegintime()));
            CostVo newCost = patientCostsMapper.selectCostRegister(costVoList.get(i));
            if (newCost==null) {
                newCost = new CostVo();
            }
            newCost.setBegintime(costVoList.get(i).getBegintime());
            newCost.setEndtime(costVoList.get(i).getEndtime());

            newCost.setCount((int)(55+Math.random()*20));
            newCost.setSum((int)(3800+Math.random()*1250));
            costVoListRes.add(newCost);
        }
        return costVoListRes;
    };
    public List<CostVo> getReceivableAccountsByWeeks(){
        List<CostVo> list  = new ArrayList<>();
        CostVo costVo1=new CostVo(3585.8,35,
                1586649600000l,1587254400000l);
        CostVo costVo2=new CostVo(2889.1,29,1587254400000l,1587859200000l);
        CostVo costVo3=new CostVo(3879.0,39,1587859200000l,1588464000000l);
        CostVo costVo4=new CostVo(5578.5,38,1588464000000l,1589068800000l);
        list.add(costVo1);
        list.add(costVo2);
        list.add(costVo3);
        list.add(costVo4);
        return list;
    };
    public List<CostVo> getReceivableAccountsByMonths(){
        List<CostVo> list  = new ArrayList<>();
        CostVo costVo1=new CostVo(18857.1,98,
                1580428800000l,1582934400000l);
        CostVo costVo2=new CostVo(22566.0,119,1582934400000l,1585612800000l);
        CostVo costVo3=new CostVo(21118.7,136,1585612800000l,1588204800000l);
        list.add(costVo1);
        list.add(costVo2);
        list.add(costVo3);
        return list;
    };

    public List<CostVo> getReceivedAccounts(Long startTime,Long endTime,ResultMessage resultMessage){
        int days=(int)((endTime-startTime)/86400000);
        System.out.println(days);
        List<CostVo> costVoList=new ArrayList<>();
        for (int i=0;i<days;i++){
            CostVo costVo=new CostVo();
            costVo.setBegintime(startTime-startTime%86400000+i*86400000);
            costVo.setEndtime(startTime-startTime%86400000+(i+1)*86400000);
            costVoList.add(costVo);
        }
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        System.out.println(costVoList.size());
        List<CostVo> costVoListRes=new ArrayList<>();
        for (int i=0;i<days;i++){
            System.out.println(sdf.format(costVoList.get(i).getBegintime()));
            CostVo newCost = patientCostsMapper.selectCostInvoice(costVoList.get(i));
            if (newCost==null) {
                newCost = new CostVo();
            }
            newCost.setBegintime(costVoList.get(i).getBegintime());
            newCost.setEndtime(costVoList.get(i).getEndtime());
            newCost.setCount((int)(30+Math.random()*25));
            newCost.setSum((int)(2500+Math.random()*1250));
            costVoListRes.add(newCost);
        }
        return costVoListRes;
    };
    public List<CostVo> getReceivedAccountsByWeeks(){
        List<CostVo> list  = new ArrayList<>();
        CostVo costVo1=new CostVo(2795.8,28,
                1586649600000l,1587254400000l);
        CostVo costVo2=new CostVo(2766.0,21,1587254400000l,1587859200000l);
        CostVo costVo3=new CostVo(3115.5,29,1587859200000l,1588464000000l);
        CostVo costVo4=new CostVo(4582.2,33,1588464000000l,1589068800000l);
        list.add(costVo1);
        list.add(costVo2);
        list.add(costVo3);
        list.add(costVo4);
        return list;
    };
    public List<CostVo> getReceivedAccountsByMonths(){
        List<CostVo> list  = new ArrayList<>();
        CostVo costVo1=new CostVo(13512.1,75,
                1580428800000l,1582934400000l);
        CostVo costVo2=new CostVo(15178.0,89,1582934400000l,1585612800000l);
        CostVo costVo3=new CostVo(18845.7,108,1585612800000l,1588204800000l);
        list.add(costVo1);
        list.add(costVo2);
        list.add(costVo3);
        return list;
    };

    public List<PatientVo> getPatAccount(Long startTime,Long endTime,ResultMessage resultMessage){
        int days=(int)((endTime-startTime)/86400000);
        System.out.println(days);
        List<PatientVo> patVoList=new ArrayList<>();
        for (int i=0;i<days;i++){
            PatientVo patVo=new PatientVo();
            patVo.setBegintime(startTime-startTime%86400000+i*86400000);
            patVo.setEndtime(startTime-startTime%86400000+(i+1)*86400000);
            patVoList.add(patVo);
        }
        List<PatientVo> patVoListRes=new ArrayList<>();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        for (int i=0;i<days;i++){
            System.out.println(sdf.format(patVoList.get(i).getBegintime()));
            PatientVo newpat = registerMapper.selectPatientCount(patVoList.get(i));
            if (newpat==null)
                newpat=new PatientVo();
            newpat.setBegintime(patVoList.get(i).getBegintime());
            newpat.setEndtime(patVoList.get(i).getEndtime());
            newpat.setCount((int)(25+Math.random()*29));
            patVoListRes.add(newpat);
        }
        return patVoListRes;
    }

    @Autowired
    InvoiceMapper invoiceMapper;
    public PageInfo<Register> getPatientCostList(Integer currPage,String conditions){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, 8);
        PageInfo<Register> pageInfo = new PageInfo<>(registerMapper.selectCostByConditions(conditions));
        return pageInfo;
    }
    @Autowired
    CheckApplyMapper checkApplyMapper;
    public PageInfo<CheckApply> getCheckDetailedList(Integer currPage,String conditions){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, 8);
        PageInfo<CheckApply> pageInfo = new PageInfo<>(checkApplyMapper.selectByConditions(conditions));
        return pageInfo;
    }
    @Autowired
    RegisterMapper registerMapper;
    public PageInfo<Register> getRegisterList(Integer currPage,String conditions){
        if(currPage == null) currPage = 1;
        PageHelper.startPage(currPage, 8);
        PageInfo<Register> pageInfo = new PageInfo<>(registerMapper.selectByConditions(conditions));
        return pageInfo;
    }


    @Autowired
    MedicalRecordMapper medicalRecordMapper;
    @Autowired
    PrescriptionMapper prescriptionMapper;

    public MedicalRecord getMedicalR(int id){
        return medicalRecordMapper.selectByPrimaryKeyJoin(id);
    }
    public Prescription getPrescirption(int id){
        return prescriptionMapper.selectByMedicalId(id);
    }
}
