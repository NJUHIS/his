package com.njuhis.his.mapper;

import com.njuhis.his.model.FmedItem;
import java.util.List;

public interface FmedItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FmedItem record);

    FmedItem selectByPrimaryKey(Integer id);

    List<FmedItem> selectAll();

    int updateByPrimaryKey(FmedItem record);
}