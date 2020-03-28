package com.njuhis.his.controller;

import com.njuhis.his.service.PharmacyService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

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

}
