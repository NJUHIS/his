package com.njuhis.his.controller;

import com.njuhis.his.model.Disease;
import com.njuhis.his.service.BasicInformationService;
import com.njuhis.his.service.UtilityService;
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
 * 多用途的、通用的组件
 */
@RestController
@RequestMapping("/UtilityController")
public class UtilityController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private UtilityService utilityService;
    @Autowired
    private BasicInformationService basicInformationService;

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


    //TODO 待测试
    @RequestMapping(value = "/getAllDiseases")
    public List<Disease> getAllDiseases(HttpServletResponse httpServletResponse) {
        quickLogger.logInvoke();
        List<Disease> result = basicInformationService.getAllDiseases(new ResultMessage(httpServletResponse));
        quickLogger.logReturn(result);
        return result;
    }

    //TODO 待测试
    @RequestMapping("/addDisease")
    public Disease addDisease(@RequestBody Disease disease, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(disease);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Disease result=basicInformationService.addDisease(disease, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }


    //TODO 待测试
    @RequestMapping("/getDiseaseById")
    public Disease getDiseaseById(@RequestParam Integer id, HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(id);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Disease result=basicInformationService.getDiseaseById(id,resultMessage);

        quickLogger.logReturn(result);
        return result;
    }



    //TODO 待测试
    @RequestMapping("/updateDisease")
    public Disease updateDisease(@RequestBody Disease disease,HttpServletResponse httpServletResponse){
        quickLogger.logInvoke();
        quickLogger.logReceive(disease);
        ResultMessage resultMessage=new ResultMessage(httpServletResponse);

        Disease result=basicInformationService.updateDisease(disease, resultMessage);

        quickLogger.logReturn(result);
        return result;

    }















}
