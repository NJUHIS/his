package com.njuhis.his.mapper;

import com.njuhis.his.model.Drugs;
import java.util.List;

public interface DrugsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drugs record);

    Drugs selectByPrimaryKey(Integer id);

    List<Drugs> selectAll();

    int updateByPrimaryKey(Drugs record);
}