package com.njuhis.his.mapper;

import com.njuhis.his.model.CheckResult;
import java.util.List;

public interface CheckResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckResult record);

    CheckResult selectByPrimaryKey(Integer id);

    List<CheckResult> selectAll();

    int updateByPrimaryKey(CheckResult record);
}