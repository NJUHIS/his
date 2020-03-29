package com.njuhis.his.mapper;

import com.njuhis.his.model.Prescription;
import java.util.List;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prescription record);

    Prescription selectByPrimaryKey(Integer id);

    List<Prescription> selectAll();

    int updateByPrimaryKey(Prescription record);

    List<Prescription> selectAllJoin();//查询全部药品处方 包含明细

    Prescription selectByRegisterId(Integer RegisterID);//通过病例id查询到处方明细
}