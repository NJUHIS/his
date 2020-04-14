package com.njuhis.his.mapper;

import com.njuhis.his.model.ExpenseClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpenseClassMapper {
    int insert(ExpenseClass record);
    int updateByPrimaryKey(ExpenseClass record);
    List<ExpenseClass> selectAll();
    ExpenseClass selectByPrimaryKey(int id);
}