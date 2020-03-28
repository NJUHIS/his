package com.njuhis.his.controller;

import com.njuhis.his.service.MedicalTechnologyService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

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
}
