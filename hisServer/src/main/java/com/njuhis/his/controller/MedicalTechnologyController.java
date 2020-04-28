package com.njuhis.his.controller;

import com.njuhis.his.model.CheckDetailed;
import com.njuhis.his.service.MedicalTechnologyService;
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
 * 门诊医技工作站
 * 检查检验医技数据维护
 */
@RestController
@RequestMapping("/MedicalTechnologyController")
public class MedicalTechnologyController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private MedicalTechnologyService medicalTechnologyService;


    /**
     * 这个函数使得這個 Controller 可以把 yyyy-MM-dd 的 String @RequestParam 轉化為 Date 類型
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


    @RequestMapping("/startCheckDetailed")
    public CheckDetailed startCheckDetailed(@RequestParam Integer checkDetailedId, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkDetailedId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckDetailed result=medicalTechnologyService.startCheckDetailed(checkDetailedId,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/finishCheckDetailed")
    public CheckDetailed finishCheckDetailed(@RequestParam Integer checkDetailedId, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkDetailedId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckDetailed result=medicalTechnologyService.finishCheckDetailed(checkDetailedId,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }

    @RequestMapping("/reportCheckDetailed")
    public CheckDetailed reportCheckDetailed(@RequestParam Integer checkDetailedId, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(checkDetailedId);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        CheckDetailed result=medicalTechnologyService.reportCheckDetailed(checkDetailedId,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }
}
