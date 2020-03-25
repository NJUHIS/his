package com.njuhis.his.mapper;

import com.njuhis.his.model.SettleCategory;
import java.util.List;


public interface SettleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SettleCategory record);

    SettleCategory selectByPrimaryKey(Integer id);

    List<SettleCategory> selectAll();

    int updateByPrimaryKey(SettleCategory record);
}