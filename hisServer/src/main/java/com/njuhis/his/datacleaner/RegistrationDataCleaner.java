package com.njuhis.his.datacleaner;

import com.njuhis.his.model.Register;
import com.njuhis.his.util.CheckUtility;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationDataCleaner {
    @Autowired
    private CheckUtility checkUtility;
    public void cleanRegistration(Register registration, ResultMessage resultMessage){
        checkUtility.checkNotEmpty(registration,registration.getNotEmptyFieldsCheckList(),resultMessage);
    }
}
