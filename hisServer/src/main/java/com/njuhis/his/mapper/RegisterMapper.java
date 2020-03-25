package com.njuhis.his.mapper;

import com.njuhis.his.model.Register;
import java.util.List;

public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    Register selectByPrimaryKey(Integer id);

    List<Register> selectAll();

    int updateByPrimaryKey(Register record);

    List<Register> selectByIdNumber(String idNumber);
}