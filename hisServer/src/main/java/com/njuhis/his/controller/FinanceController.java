package com.njuhis.his.controller;

import com.njuhis.his.service.FinanceService;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author Paul
 * 门诊财务管理
 * 财务管理数据维护
 */
@RestController
@RequestMapping("/FinanceController")
public class FinanceController {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private FinanceService financeService;
}
