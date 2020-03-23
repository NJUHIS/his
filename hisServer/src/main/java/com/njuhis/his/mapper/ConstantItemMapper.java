package com.njuhis.his.mapper;

import com.njuhis.his.model.ConstantItem;
import java.util.List;

public interface ConstantItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstantItem record);

    ConstantItem selectByPrimaryKey(Integer id);

    List<ConstantItem> selectAll();

    int updateByPrimaryKey(ConstantItem record);
}