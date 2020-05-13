package com.njuhis.his.controller;

import com.njuhis.his.model.Prescription;
import com.njuhis.his.service.PharmacyService;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Paul
 * 门诊药房工作站
 * 药房管理信息数据维护
 */
@RestController
@RequestMapping("/PharmacyController")
public class PharmacyController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private PharmacyService pharmacyService;

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


    @RequestMapping("/dispenseMedicine")
    public Prescription dispenseMedicine(@RequestParam Integer prescriptionId, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(prescriptionId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Prescription result=pharmacyService.dispenseMedicine(prescriptionId,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }





}
