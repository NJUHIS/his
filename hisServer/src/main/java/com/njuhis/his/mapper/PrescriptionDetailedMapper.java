package com.njuhis.his.mapper;

import com.njuhis.his.model.PrescriptionDetailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrescriptionDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrescriptionDetailed record);

    PrescriptionDetailed selectByPrimaryKey(Integer id);

    List<PrescriptionDetailed> selectAll();

    int updateByPrimaryKey(PrescriptionDetailed record);


}