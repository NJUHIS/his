package com.njuhis.his.mapper;

import com.njuhis.his.model.Disease;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DiseaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Disease record);

    Disease selectByPrimaryKey(Integer id);

    List<Disease> selectAll();

    int updateByPrimaryKey(Disease record);
}