package com.njuhis.his.datacleaner;

import com.njuhis.his.model.Scheduling;
import com.njuhis.his.util.CheckUtil;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicInformationDataCleaner {
    @Autowired
    private CheckUtil checkUtil;
    public void cleanScheduling(Scheduling scheduling, ResultMessage resultMessage){
        checkUtil.checkNotEmpty(scheduling,scheduling.getNotEmptyFieldsCheckList(),resultMessage);
    }
}
