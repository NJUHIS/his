package com.njuhis.his.mapper;

import com.njuhis.his.model.CheckApply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CheckApplyMapper {
    @Deprecated
    int deleteByPrimaryKey(Integer id);
    int insert(CheckApply record);

    int updateByPrimaryKey(CheckApply record);


    @Deprecated
    CheckApply selectByMedicalId(Integer medicalId);

    /**
     * @author Paul
     * @param id
     * @return
     */
    CheckApply selectByPrimaryKeyExcludingDeleted(Integer id);

    /**
     * @author Paul
     * @return
     */
    List<CheckApply> selectAllExcludingDeleted();



    List<CheckApply> selectByConditions(String conditions);

//    List<CheckApply> selectAllJoin();
//    @Deprecated
//    CheckApply selectByPrimaryKey(Integer id);
//    @Deprecated
//    List<CheckApply> selectAll();
}