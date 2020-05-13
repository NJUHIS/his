package com.njuhis.his.service;

import com.njuhis.his.model.Prescription;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private DoctorService doctorService;

    public Prescription dispenseMedicine(Integer prescriptionId, ResultMessage resultMessage){
        Prescription prescription=doctorService.getPrescriptionById(prescriptionId,resultMessage);if(!resultMessage.isSuccessful())return null;

        if(prescription.getPrescriptionState()!=3){//如果不是 3 - 已收费，未取药。
            resultMessage.sendClientError("The state is not 3. 状态不是 3 - 已收费，未取药。");
            return null;
        }

        prescription.setPrescriptionState(4);// 4 - 已取药。。
        prescription=doctorService.updatePrescriptionInternal(prescription,resultMessage);if(!resultMessage.isSuccessful())return null;

        return prescription;
    }


}
