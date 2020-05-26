package com.njuhis.his.datacleaner;

import com.njuhis.his.model.CheckApply;
import com.njuhis.his.model.CheckDetailed;
import com.njuhis.his.model.Prescription;
import com.njuhis.his.model.PrescriptionDetailed;
import com.njuhis.his.util.CheckUtility;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorDataCleaner {
    @Autowired
    private CheckUtility checkUtility;
    public void cleanCheckApply(CheckApply checkApply, ResultMessage resultMessage){
        checkUtility.checkNotEmpty(checkApply, CheckApply.getNotEmptyFieldsCheckList(),resultMessage);
    }

    public void cleanCheckDetailed(CheckDetailed checkDetailed, ResultMessage resultMessage){
        checkUtility.checkNotEmpty(checkDetailed, CheckDetailed.getNotEmptyFieldsCheckList(),resultMessage);
    }

    public void cleanPrescriptionForAddPrescription(Prescription prescription, ResultMessage resultMessage){
        checkUtility.checkNotEmpty(prescription, Prescription.getNotEmptyFieldsCheckList(),resultMessage);
    }
    public void cleanPrescriptionDetailedForAddPrescriptionDetailed(PrescriptionDetailed prescriptionDetailed,ResultMessage resultMessage){
        checkUtility.checkNotEmpty(prescriptionDetailed,PrescriptionDetailed.getNotEmptyFieldsCheckList(),resultMessage);
    }
}
