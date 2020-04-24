package com.njuhis.his.controller;

import com.njuhis.his.model.Invoice;
import com.njuhis.his.model.PatientCosts;
import com.njuhis.his.model.Register;
import com.njuhis.his.service.RegistrationService;
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
 * 门诊挂号收费
 * 门诊挂号收费数据管理
 */
@RestController
@RequestMapping("/RegistrationController")
public class RegistrationController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private RegistrationService registrationService;


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

    @RequestMapping("/getRegistrationsByConditions")
    public List<Register> getRegistrationsByConditions(
            @RequestParam(required = false)Date fromVisitDate,
            @RequestParam(required = false)Integer fromNoon,
            @RequestParam(required = false)Date toVisitDate,
            @RequestParam(required = false)Integer toNoon,
            @RequestParam(required = false)Integer departmentId,
            @RequestParam(required = false)Integer userId,
            @RequestParam(required = false)Integer registrationTypeId,
            @RequestParam(required = false)Integer settlementTypeId,
            @RequestParam(required = false)Integer needBook,
            @RequestParam(required = false)Integer registrarId,
            @RequestParam(required = false)Integer visitState,
            @RequestParam(required = false)Integer patientId,
            HttpServletResponse httpServletResponse
    ){
        quickLogger.logInvoke();
        quickLogger.logReceive(
    "fromVisitDate",              fromVisitDate,
              "fromNoon",                  fromNoon,
              "toVisitDate",               toVisitDate,
              "toNoon",                    toNoon,
              "departmentId",              departmentId,
              "userId",                    userId,
              "registrationTypeId",        registrationTypeId,
              "settlementTypeId",          settlementTypeId,
              "needBook",                  needBook,
              "registrarId",               registrarId,
              "visitState",                visitState,
              "patientId",                 patientId
        );
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        List<Register> result=registrationService.getRegistrationsByConditions(fromVisitDate,fromNoon,toVisitDate,toNoon,departmentId,userId,registrationTypeId,settlementTypeId,needBook,registrarId,visitState,patientId,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }




}



