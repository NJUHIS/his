package com.njuhis.his.service;

import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.mapper.PatientMapper;
import com.njuhis.his.mapper.UserMapper;
import com.njuhis.his.model.Department;
import com.njuhis.his.model.Patient;
import com.njuhis.his.model.User;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInformationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;

    public List<Department> getAllDepartments(ResultMessage resultMessage){
        return departmentMapper.selectAll();
    }

    /**
     * @param user user 的 id 會從無到有
     */
    public void addUser(User user, ResultMessage resultMessage){
        try {
            userMapper.insert(user);
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
        }
    }


}
