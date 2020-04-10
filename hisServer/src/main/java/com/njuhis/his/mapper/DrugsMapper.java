package com.njuhis.his.mapper;

import com.njuhis.his.model.Drugs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DrugsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drugs record);

    Drugs selectByPrimaryKey(Integer id);

    List<Drugs> selectAll();

    int updateByPrimaryKey(Drugs record);
}