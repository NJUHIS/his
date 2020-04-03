package com.njuhis.his.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Autowired
    private PatientMapper patientMapper;

    public List<Department> getAllDepartments(ResultMessage resultMessage){
        return departmentMapper.selectAll();
    }

    /**
     * @param user user 的 id 會從無到有
     */
    public User addUser(User user, ResultMessage resultMessage){
        try {
            userMapper.insert(user);
            return user;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public List<User> getUsersBetweenScheduleDates(Long startDate, Long endDate,int pageNumber, int pageSize,  ResultMessage resultMessage){
        //TODO 邏輯待補充完整

        //下面作為PageHelper的使用範例
//        PageHelper.startPage(pageNumber,pageSize);
//        List<User> userList=userMapper.selectAll();
//        return new PageInfo(userList);

        List<User> userList=userMapper.selectAll();
        return userList;

    }

    public List<Patient> getPatientsBetweenScheduleDates(Long startDate, Long endDate,int pageNumber, int pageSize,  ResultMessage resultMessage){
        //TODO 邏輯待補充完整

        return patientMapper.selectAll();
    }


}
