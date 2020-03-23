package com.njuhis.his.mapper;

import com.njuhis.his.model.Disease;
import java.util.List;

public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Disease record);

    Disease selectByPrimaryKey(Integer id);

    List<Disease> selectAll();

    int updateByPrimaryKey(Disease record);
}