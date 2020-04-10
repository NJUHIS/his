package com.njuhis.his.mapper;

import com.njuhis.his.model.FmedItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FmedItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FmedItem record);

    FmedItem selectByPrimaryKey(Integer id);

    List<FmedItem> selectAll();

    int updateByPrimaryKey(FmedItem record);
}