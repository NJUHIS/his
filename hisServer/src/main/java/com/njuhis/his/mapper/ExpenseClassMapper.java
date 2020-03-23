package com.njuhis.his.mapper;

import com.njuhis.his.model.ExpenseClass;
import java.util.List;

public interface ExpenseClassMapper {
    int insert(ExpenseClass record);

    List<ExpenseClass> selectAll();
}