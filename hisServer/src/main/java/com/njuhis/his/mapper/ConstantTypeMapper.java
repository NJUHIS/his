package com.njuhis.his.mapper;

import com.njuhis.his.model.ConstantType;
import java.util.List;

public interface ConstantTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstantType record);

    ConstantType selectByPrimaryKey(Integer id);

    List<ConstantType> selectAll();

    int updateByPrimaryKey(ConstantType record);
}