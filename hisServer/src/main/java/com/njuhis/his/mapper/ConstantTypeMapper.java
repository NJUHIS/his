package com.njuhis.his.mapper;

import com.njuhis.his.model.ConstantType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConstantTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstantType record);

    ConstantType selectByPrimaryKey(Integer id);

    List<ConstantType> selectAll();

    int updateByPrimaryKey(ConstantType record);
}