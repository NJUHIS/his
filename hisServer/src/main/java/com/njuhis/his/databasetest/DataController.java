package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.*;
import com.njuhis.his.model.*;
import com.njuhis.his.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    DrugsMapper drugsMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    RegisterMapper registerMapper;
    @Autowired
    SchedulingMapper schedulingMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PatientMapper patientMapper;
    @RequestMapping("/drugs")
    public List<Drugs> selectAllDrugs(){
        return drugsMapper.selectAll();
    }
    @RequestMapping("/department")
    public List<Department> selectAllDepartment(){
        return departmentMapper.selectAll();
    }
    @RequestMapping("/register")
    List<Register> selectAllRegister(){
        return registerMapper.selectAll();
    }
    @RequestMapping("/register/{idNumber}")
    List<Register> selectAllRegister(@PathVariable String idNumber){
        System.out.println(idNumber);
        return registerMapper.selectByIdNumber(idNumber);
    }
    @RequestMapping("/register/p/{patientID}")
    List<Register> selectAllRegister(@PathVariable int patientID){
        System.out.println(patientID);
        return registerMapper.selectByPatientId(patientID);
    }
    @RequestMapping("register/in")
    int insert(){
        Register record =new Register();
        record.setNoon(0);
        registerMapper.insert(record);
        System.out.println(record.getId());
        return 0;
    }
    @RequestMapping("/se/{departmentID}")
    List<Scheduling> selectScheduling(@PathVariable int departmentID){
        System.out.println(departmentID);
        Scheduling scheduling = new Scheduling();
        scheduling.setDeptid(3);
        scheduling.setNoon(1);
        Date date = new Date(2019-1900,03-1,01,8,0);
        System.out.println(date);
        scheduling.setScheddate(date);
        List<Scheduling> s= schedulingMapper.selectByDepartmentAndNoon(scheduling);
        return schedulingMapper.selectByDepartmentAndNoon(scheduling);
    }
    @RequestMapping("/insert")
    void insertUser(){
        User user = new User();
        user.setUsername("aa");
        user.setRealname("aa");
        user.setDelmark(0);
        user.setDeptid(3);
        userMapper.insert(user);
    }
    @RequestMapping("/seu")
    User  seUser(){

        System.out.println(userMapper.selectByUserName("ahilla").toString());
        return userMapper.selectByUserName("ahilla");
    }
    @RequestMapping("/sep")
    Patient sePatient(){
        return patientMapper.selectByLoginName("ahilla");
    }
    @Autowired
    PrescriptionMapper prescriptionMapper;
    @RequestMapping("/pso")
    List<Prescription> sePrescription(){
        return prescriptionMapper.selectAllJoin();
    }
    @Autowired
    CheckApplyMapper checkApplyMapper;
    @RequestMapping("/cso")
    List<CheckApply> seCheckApplly(){
        //return checkApplyMapper.selectAllJoin();
        return checkApplyMapper.selectAllExcludingDeleted();
    }


    @Autowired
    InvoiceMapper invoiceMapper;
    @RequestMapping("/iso")
    List<Invoice> seInvoice(){
        return  invoiceMapper.selectAllJoin();
    }

    @Autowired
    MedicalRecordMapper medicalRecordMapper;
    @RequestMapping("/rso")
    List<MedicalRecord> seRegister(){
        return  medicalRecordMapper.selectAllExcludingDeleted();
    }


    @RequestMapping("/dso")
    List<Department> seDept(){
        return  departmentMapper.selectAllJoin();
    }

    @Autowired
    PatientCostsMapper patientCostsMapper;
    @RequestMapping("/cost")
    CostVo costPo(){
        CostVo costVo =new CostVo(0,0,999,1000002);

        return  patientCostsMapper.selectCostInvoice(costVo);
    }
    @Autowired
    PrescriptionDetailedMapper prescriptionDetailedMapper;
    @Autowired
    CheckDetailedMapper checkDetailedMapper;
    @RequestMapping("/ins")
    void ins(){
        prescriptionDetailedMapper.insert(new PrescriptionDetailed());
        checkDetailedMapper.insert(new CheckDetailed());
    }
    @Autowired
    ExpenseClassMapper expenseClassMapper;
    @RequestMapping("/exp")
    void exp(){
        ExpenseClass aa = new ExpenseClass();
        aa.setId(22);

        aa.setDelmark(1);
        expenseClassMapper.updateByPrimaryKey(aa);
    }

    @RequestMapping("rcp")
    PatientVo patientVo(){


        Date d =new Date(1000000000000l);

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        //86400000

        System.out.println("rcp");
        PatientVo patientVo = new PatientVo();
        patientVo.setBegintime(1);
        patientVo.setEndtime(11115);
        return registerMapper.selectPatientCount(patientVo);

    }
    @Autowired
    AdministrationService administrationService;

    @RequestMapping("test")
    List<CheckApply> test(){
        System.out.println("啥玩意");
        return checkApplyMapper.selectByConditions("");
    }
}
