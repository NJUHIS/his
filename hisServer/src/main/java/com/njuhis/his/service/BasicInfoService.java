package com.njuhis.his.service;

import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.model.Department;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInfoService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public List<Department> getAllDepartments(ResultMessage resultMessage){
        return departmentMapper.selectAll();
    }
}
