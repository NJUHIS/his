package com.njuhis.his.controller;

import com.njuhis.his.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author Paul
 * 门诊挂号收费
 * 门诊挂号收费数据管理
 */
@RestController
@RequestMapping("registration")
public class RegistrationController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private RegistrationService registrationService;
}



