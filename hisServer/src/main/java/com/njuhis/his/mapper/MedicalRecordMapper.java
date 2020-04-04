package com.njuhis.his.mapper;

import com.njuhis.his.model.MedicalRecord;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MedicalRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(Integer id);

    List<MedicalRecord> selectAll();

    int updateByPrimaryKey(MedicalRecord record);

    List<MedicalRecord> selectAllJoin();

    MedicalRecord selectByPrimaryKeyJoin(Integer id);
}