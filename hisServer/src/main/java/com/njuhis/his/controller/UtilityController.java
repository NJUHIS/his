package com.njuhis.his.controller;

import com.njuhis.his.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author Paul
 * 多用途的、通用的组件
 */
@RestController
@RequestMapping("/utility")
public class UtilityController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private UtilityService utilityService;
}
