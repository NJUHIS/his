package com.njuhis.his.mapper;

import com.njuhis.his.model.PatientCosts;
import java.util.List;

public interface PatientCostsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientCosts record);

    PatientCosts selectByPrimaryKey(Integer id);

    List<PatientCosts> selectAll();

    int updateByPrimaryKey(PatientCosts record);
}