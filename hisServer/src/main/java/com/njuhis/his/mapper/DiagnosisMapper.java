package com.njuhis.his.mapper;

import com.njuhis.his.model.Diagnosis;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DiagnosisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diagnosis record);

    Diagnosis selectByPrimaryKeyExcludingDeleted(Integer id);

    List<Diagnosis> selectAllExcludingDeleted();

    int updateByPrimaryKey(Diagnosis record);
}