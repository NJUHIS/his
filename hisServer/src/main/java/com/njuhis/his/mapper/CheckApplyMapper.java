package com.njuhis.his.mapper;

import com.njuhis.his.model.CheckApply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CheckApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckApply record);

    CheckApply selectByPrimaryKey(Integer id);

    List<CheckApply> selectAll();

    int updateByPrimaryKey(CheckApply record);

    List<CheckApply> selectAllJoin();

    CheckApply selectByMedicalId(Integer medicalId);

    CheckApply selectByPrimaryKeyJoin(Integer id);
}