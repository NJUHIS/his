package com.njuhis.his.mapper;

import com.njuhis.his.model.Scheduling;
import java.util.List;

public interface SchedulingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scheduling record);

    Scheduling selectByPrimaryKey(Integer id);

    List<Scheduling> selectAll();

    int updateByPrimaryKey(Scheduling record);

    List<Scheduling> selectByDepartment(Scheduling scheduling);
}