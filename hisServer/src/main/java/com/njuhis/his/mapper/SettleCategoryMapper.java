package com.njuhis.his.mapper;

import com.njuhis.his.model.SettleCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SettleCategory record);

    SettleCategory selectByPrimaryKey(Integer id);

    List<SettleCategory> selectAll();

    int updateByPrimaryKey(SettleCategory record);
}