package com.njuhis.his.controller;

import com.njuhis.his.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author Paul
 * 基础信息管理
 * 医院系统管理数据维护
 */
@RequestMapping("basinInfo")
@RestController
public class BasicInfoController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private BasicInfoService basicInfoService;
}
