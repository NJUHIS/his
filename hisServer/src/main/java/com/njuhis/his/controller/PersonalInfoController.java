package com.njuhis.his.controller;

import com.njuhis.his.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author Paul
 * 个人信息管理
 * 个人信息数据修改维护
 */
@RestController
@RequestMapping("personalInfo")
public class PersonalInfoController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private PersonalInfoService personalInfoService;
}
