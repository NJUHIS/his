package com.njuhis.his.mapper;

import com.njuhis.his.model.CostPo;
import com.njuhis.his.model.PatientCosts;
import java.util.List;

public interface PatientCostsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientCosts record);

    PatientCosts selectByPrimaryKey(Integer id);

    List<PatientCosts> selectAll();

    int updateByPrimaryKey(PatientCosts record);

    PatientCosts selectByRegisterId(Integer RegisterId);

    CostPo selectCostInvoice(CostPo costPo);

    CostPo selectCostRegister(CostPo costPo);
}