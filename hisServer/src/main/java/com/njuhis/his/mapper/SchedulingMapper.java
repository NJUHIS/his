package com.njuhis.his.mapper;

import com.njuhis.his.model.Scheduling;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SchedulingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scheduling record);

    Scheduling selectByPrimaryKeyExcludingDeleted(Integer id);

    List<Scheduling> selectAllExcludingDeleted();

    int updateByPrimaryKey(Scheduling record);

    List<Scheduling> selectByDepartmentAndNoon(Scheduling scheduling);
}