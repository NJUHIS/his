package com.njuhis.his.datacleaner;

import com.njuhis.his.model.CheckApply;
import com.njuhis.his.util.CheckUtil;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorDataCleaner {
    @Autowired
    private CheckUtil checkUtil;
    public void cleanCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        checkUtil.checkNotEmpty(checkApply,checkApply.getNotEmptyFieldsCheckList(),resultMessage);
    }
}
