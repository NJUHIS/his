package com.njuhis.his.mapper;

import com.njuhis.his.model.CostPo;
import com.njuhis.his.model.PatientCosts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientCostsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientCosts record);

    PatientCosts selectByPrimaryKey(Integer id);

    List<PatientCosts> selectAll();

    int updateByPrimaryKey(PatientCosts record);

    List<PatientCosts> selectByRegisterId(Integer RegisterId);

    CostPo selectCostInvoice(CostPo costPo);

    CostPo selectCostRegister(CostPo costPo);
}