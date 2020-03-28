package com.njuhis.his.controller;

import com.njuhis.his.service.DoctorService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
