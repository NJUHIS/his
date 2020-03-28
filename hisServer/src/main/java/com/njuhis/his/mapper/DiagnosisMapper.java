package com.njuhis.his.mapper;

import com.njuhis.his.model.Diagnosis;
import java.util.List;

public interface DiagnosisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diagnosis record);

    Diagnosis selectByPrimaryKey(Integer id);

    List<Diagnosis> selectAll();

    int updateByPrimaryKey(Diagnosis record);
}