package com.njuhis.his.mapper;

import com.njuhis.his.model.ConstantItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConstantItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstantItem record);

    ConstantItem selectByPrimaryKey(Integer id);

    List<ConstantItem> selectAll();

    int updateByPrimaryKey(ConstantItem record);
}