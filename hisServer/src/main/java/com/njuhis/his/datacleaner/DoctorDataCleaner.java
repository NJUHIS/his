package com.njuhis.his.datacleaner;

import com.njuhis.his.model.CheckApply;
import com.njuhis.his.model.Prescription;
import com.njuhis.his.util.CheckUtility;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorDataCleaner {
    @Autowired
    private CheckUtility checkUtility;
    public void cleanCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        checkUtility.checkNotEmpty(checkApply,checkApply.getNotEmptyFieldsCheckList(),resultMessage);
    }

    public void cleanPrescriptionForAddPrescription(Prescription prescription, ResultMessage resultMessage){
        checkUtility.checkNotEmpty(prescription,prescription.getNotEmptyFieldsCheckList(),resultMessage);
    }
}
