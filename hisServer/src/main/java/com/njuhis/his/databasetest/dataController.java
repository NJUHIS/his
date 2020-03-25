package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.mapper.DrugsMapper;
import com.njuhis.his.mapper.RegisterMapper;
import com.njuhis.his.mapper.SchedulingMapper;
import com.njuhis.his.model.Department;
import com.njuhis.his.model.Drugs;
import com.njuhis.his.model.Register;
import com.njuhis.his.model.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return schedulingMapper.selectByDepartment(departmentID);
    }
}
