package com.njuhis.his.mapper;

import com.njuhis.his.model.CheckDetailed;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CheckDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckDetailed record);

    CheckDetailed selectByPrimaryKeyExcludingDeleted(Integer id);

    List<CheckDetailed> selectAllExcludingDeleted();

    int updateByPrimaryKey(CheckDetailed record);

    List<CheckDetailed> selectByDeptId(Integer deptId);
}