package com.njuhis.his.controller;

import com.njuhis.his.model.CheckApply;
import com.njuhis.his.model.Invoice;
import com.njuhis.his.model.MedicalRecord;
import com.njuhis.his.model.Register;
import com.njuhis.his.service.DoctorService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * @author Paul
 * 门诊医生工作站
 * 门诊医生工作数据维护
 */
@RestController
@RequestMapping("/DoctorController")
public class DoctorController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/admit")
    public Register admit(@RequestParam Integer registrationId, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(registrationId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Register result=doctorService.admit(registrationId,resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getMedicalRecordById")
    public MedicalRecord getMedicalRecordById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        MedicalRecord result=doctorService.getMedicalRecordById(id, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/addCheckApply")
    public CheckApply addCheckApply(@RequestBody CheckApply checkApply,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(checkApply);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.addCheckApply(checkApply, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/getCheckApplyById")
    public CheckApply getCheckApplyById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.getCheckApplyById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/updateCheckApply")
    public CheckApply updateCheckApply(@RequestBody CheckApply checkApply,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(checkApply);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.updateCheckApply(checkApply, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/updateMedicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord,HttpServletResponse httpServletResponse){
        quickLogger.logInvoked();
        quickLogger.logReceive(medicalRecord);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        MedicalRecord result=doctorService.updateMedicalRecord(medicalRecord, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }
}
