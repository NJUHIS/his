package com.njuhis.his.mapper;

import com.njuhis.his.model.CostVo;
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

    CostVo selectCostInvoice(CostVo costVo);

    CostVo selectCostRegister(CostVo costVo);

    List<PatientCosts> selectByConditions(String conditions);
}