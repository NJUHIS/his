package com.njuhis.his.mapper;

import com.njuhis.his.model.CheckApply;
import java.util.List;

public interface CheckApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckApply record);

    CheckApply selectByPrimaryKey(Integer id);

    List<CheckApply> selectAll();

    int updateByPrimaryKey(CheckApply record);
}