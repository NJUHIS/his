package com.njuhis.his.controller;

import com.njuhis.his.model.Invoice;
import com.njuhis.his.model.PatientCosts;
import com.njuhis.his.model.Register;
import com.njuhis.his.service.RegistrationService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Paul
 * 门诊挂号收费
 * 门诊挂号收费数据管理
 */
@RestController
@RequestMapping("/RegistrationController")
public class RegistrationController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private RegistrationService registrationService;


    @RequestMapping("/addRegistration")
    public Register addRegistration(@RequestBody Register registration, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(registration);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Register result=registrationService.addRegistration(registration,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/getRegistrationById")
    public Register getRegistrationById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Register result=registrationService.getRegistrationById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/updateRegistration")
    public Register updateRegistration(@RequestBody Register register, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(register);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Register result=registrationService.updateRegistration(register, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    /**
     * 範例
     * @param invoice
     * @param httpServletResponse
     * @return
     */

    @RequestMapping("/addInvoice")
    public Invoice addInvoice(@RequestBody Invoice invoice,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(invoice);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Invoice result=registrationService.addInvoice(invoice, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getInvoiceById")
    public Invoice getInvoiceById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Invoice result=registrationService.getInvoiceById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/updateInvoice")
    public Invoice updateInvoice(@RequestBody Invoice invoice,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(invoice);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Invoice result=registrationService.updateInvoice(invoice, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/addPatientCosts")
    public PatientCosts addPatientCosts(@RequestBody PatientCosts patientCosts, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(patientCosts);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        PatientCosts result=registrationService.addPatientCosts(patientCosts, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }

    @RequestMapping("/getPatientCostsById")
    public PatientCosts getPatientCostsById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        PatientCosts result=registrationService.getPatientCostsById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }


    @RequestMapping("/updatePatientCosts")
    public PatientCosts updateInvoice(@RequestBody PatientCosts patientCosts,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(patientCosts);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        PatientCosts result=registrationService.updatePatientCosts(patientCosts, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }




}



