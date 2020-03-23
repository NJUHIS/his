package com.njuhis.his.mapper;

import com.njuhis.his.model.PrescriptionDetailed;
import java.util.List;

public interface PrescriptionDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrescriptionDetailed record);

    PrescriptionDetailed selectByPrimaryKey(Integer id);

    List<PrescriptionDetailed> selectAll();

    int updateByPrimaryKey(PrescriptionDetailed record);
}