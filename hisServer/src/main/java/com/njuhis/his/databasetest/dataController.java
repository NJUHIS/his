package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.*;
import com.njuhis.his.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/data")
public class dataController {
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
        scheduling.setNoon("1");
        Date date = new Date(2019-1900,03-1,01,8,0);
        System.out.println(date);
        scheduling.setScheddate(date);
        List<Scheduling> s= schedulingMapper.selectByDepartment(scheduling);
        return schedulingMapper.selectByDepartment(scheduling);
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
}
