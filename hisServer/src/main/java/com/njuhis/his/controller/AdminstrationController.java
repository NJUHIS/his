package com.njuhis.his.controller;

import com.njuhis.his.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author Paul
 * 医院行政管理
 * 医院统计信息查看管理
 */
@RestController
@RequestMapping("admin")
public class AdminstrationController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private AdminService adminService;
}
