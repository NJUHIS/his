package com.njuhis.his.controller;

import com.njuhis.his.model.*;
import com.njuhis.his.service.DoctorService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


    /**
     * 这个函数使得這個 Controller 可以把 yyyy-MM-dd 的 String RequestParam 轉化為 Date 類型
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping("/admit")
    public Register admit(@RequestParam Integer registrationId, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(registrationId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Register result=doctorService.admit(registrationId,resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getMedicalRecordById")
    public MedicalRecord getMedicalRecordById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        MedicalRecord result=doctorService.getMedicalRecordById(id, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/addCheckApply")
    public CheckApply addCheckApply(@RequestBody CheckApply checkApply,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkApply);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.addCheckApply(checkApply, resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/getCheckApplyById")
    public CheckApply getCheckApplyById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.getCheckApplyById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/updateCheckApply")
    public CheckApply updateCheckApply(@RequestBody CheckApply checkApply,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkApply);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.updateCheckApplyExternal(checkApply, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/updateMedicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(medicalRecord);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        MedicalRecord result=doctorService.updateMedicalRecordExternal(medicalRecord, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    @RequestMapping("/addPrescription")
    public Prescription addPrescription(@RequestBody Prescription prescription,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(prescription);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Prescription result=doctorService.addPrescription(prescription, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getPrescriptionById")
    public Prescription getPrescriptionById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Prescription result=doctorService.getPrescriptionById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/updatePrescription")
    public Prescription updateInvoice(@RequestBody Prescription prescription,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(prescription);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Prescription result=doctorService.updatePrescriptionExternal(prescription, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待測試
    @RequestMapping("/addCheckDetailed")
    public CheckDetailed addCheckDetailed(@RequestBody CheckDetailed checkDetailed,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkDetailed);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckDetailed result=doctorService.addCheckDetailed(checkDetailed, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待測試
    @RequestMapping("/getCheckDetailedById")
    public CheckDetailed getInvoiceById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckDetailed result=doctorService.getCheckDetailedById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待測試
    @RequestMapping("/updateCheckDetailed")
    public CheckDetailed updateCheckDetailed(@RequestBody CheckDetailed checkDetailed,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkDetailed);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckDetailed result=doctorService.updateCheckDetailedExternal(checkDetailed, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待測試
    @RequestMapping("/addPrescriptionDetailed")
    public PrescriptionDetailed addPrescriptionDetailed(@RequestBody PrescriptionDetailed prescriptionDetailed,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(prescriptionDetailed);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        PrescriptionDetailed result=doctorService.addPrescriptionDetailed(prescriptionDetailed, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    //TODO 待測試
    @RequestMapping("/getPrescriptionDetailedById")
    public PrescriptionDetailed getPrescriptionDetailedById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        PrescriptionDetailed result=doctorService.getPrescriptionDetailedById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    //TODO 待測試
    @RequestMapping("/updatePrescriptionDetailed")
    public PrescriptionDetailed updateCheckDetailed(@RequestBody PrescriptionDetailed prescriptionDetailed,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(prescriptionDetailed);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        PrescriptionDetailed result=doctorService.updatePrescriptionDetailed(prescriptionDetailed, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    @RequestMapping("/getCheckAppliesByConditions")
    public List<CheckApply> getCheckAppliesByConditions(@RequestParam(required = false) Integer userId,
                                                        @RequestParam(required = false) Integer state,
                                                        @RequestParam(required = false) Integer registrationId,
                                                        HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive("userId",userId,"state",state,"registrationId",registrationId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        List<CheckApply> result=doctorService.getCheckAppliesByConditions(userId,state,registrationId,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/getPrescriptionsByConditions")
    public List<Prescription> getPrescriptionsByConditions(@RequestParam(required = false) Integer userId,
                                                           @RequestParam(required=false) Integer prescriptionState,
                                                           HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive("userId",userId,"prescriptionState",prescriptionState);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        List<Prescription> result=doctorService.getPrescriptionsByConditions(userId,prescriptionState,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/confirmCheckApply")
    public CheckApply confirmCheckApply(@RequestParam Integer checkApplyId,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkApplyId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckApply result=doctorService.confirmCheckApply(checkApplyId,resultMessage);

        quickLogger.logReceive(result);
        return result;
    }


    @RequestMapping("/getMedicalRecordsByConditions")
    public List<MedicalRecord> getMedicalRecordsByConditions(@RequestParam(required = false) Integer userId,
                                                           @RequestParam(required=false) Integer patientId,
                                                             @RequestParam(required=false) Integer registrationId,
                                                             @RequestParam(required=false) Integer caseState,
                                                           HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive("userId",userId,"patientId",patientId,"registrationId", registrationId,"caseState",caseState);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        List<MedicalRecord> result=doctorService.getMedicalRecordsByConditions(userId,patientId,registrationId,caseState,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }




}
