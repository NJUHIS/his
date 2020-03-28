package com.njuhis.his.mapper;

import com.njuhis.his.model.Register;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    Register selectByPrimaryKey(Integer id);

    List<Register> selectAll();

    int updateByPrimaryKey(Register record);

    List<Register> selectByPatientId(Integer patientId);
    List<Register> selectByIdNumber(String idNumber);
}