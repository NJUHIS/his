package com.njuhis.his.controller;

import com.njuhis.his.service.DoctorService;
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
@RequestMapping("doctor")
public class DoctorController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private DoctorService doctorService;
}
