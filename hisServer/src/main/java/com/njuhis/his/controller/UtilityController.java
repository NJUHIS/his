package com.njuhis.his.controller;

import com.njuhis.his.service.UtilityService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

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
}
