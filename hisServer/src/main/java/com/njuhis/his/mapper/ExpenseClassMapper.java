package com.njuhis.his.mapper;

import com.njuhis.his.model.ExpenseClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpenseClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseClass record);

    ExpenseClass selectByPrimaryKey(Integer id);

    List<ExpenseClass> selectAll();

    int updateByPrimaryKey(ExpenseClass record);
}