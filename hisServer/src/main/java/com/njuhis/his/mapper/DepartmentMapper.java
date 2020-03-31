package com.njuhis.his.mapper;

import com.njuhis.his.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    Department selectByPrimaryKey(Integer id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    List<Department> selectAllJoin();
}