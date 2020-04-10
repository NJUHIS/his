package com.njuhis.his.mapper;

import com.njuhis.his.model.ExpenseClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpenseClassMapper {
    int insert(ExpenseClass record);

    List<ExpenseClass> selectAll();
}