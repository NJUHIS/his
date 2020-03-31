package com.njuhis.his.mapper;

import com.njuhis.his.model.CheckDetailed;
import java.util.List;

public interface CheckDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckDetailed record);

    CheckDetailed selectByPrimaryKey(Integer id);

    List<CheckDetailed> selectAll();

    int updateByPrimaryKey(CheckDetailed record);

    List<CheckDetailed> selectByDeptId(Integer deptId);
}