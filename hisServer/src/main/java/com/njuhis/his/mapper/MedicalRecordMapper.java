package com.njuhis.his.mapper;

import com.njuhis.his.model.MedicalRecord;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecord record);

//    MedicalRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(MedicalRecord record);

    List<MedicalRecord> selectAllExcludingDeleted();

    MedicalRecord selectByPrimaryKeyExcludingDeleted(Integer id);
}