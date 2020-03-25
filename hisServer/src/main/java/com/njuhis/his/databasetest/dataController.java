package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.mapper.DrugsMapper;
import com.njuhis.his.mapper.RegisterMapper;
import com.njuhis.his.model.Department;
import com.njuhis.his.model.Drugs;
import com.njuhis.his.model.Register;
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
}
