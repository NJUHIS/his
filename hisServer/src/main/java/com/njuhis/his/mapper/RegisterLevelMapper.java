package com.njuhis.his.mapper;

import com.njuhis.his.model.RegisterLevel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegisterLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegisterLevel record);

    RegisterLevel selectByPrimaryKey(Integer id);

    List<RegisterLevel> selectAll();

    int updateByPrimaryKey(RegisterLevel record);
}