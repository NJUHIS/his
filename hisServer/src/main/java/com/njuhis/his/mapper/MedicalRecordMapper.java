package com.njuhis.his.mapper;

import com.njuhis.his.model.MedicalRecord;
import java.util.List;

public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(Integer id);

    List<MedicalRecord> selectAll();

    int updateByPrimaryKey(MedicalRecord record);
}