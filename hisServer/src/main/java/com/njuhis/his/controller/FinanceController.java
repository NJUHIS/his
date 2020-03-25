package com.njuhis.his.controller;

import com.njuhis.his.service.FinanceService;
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
@RequestMapping("finance")
public class FinanceController {
    private Logger logger=Logger.getLogger(getClass().getName());
    @Autowired
    private FinanceService financeService;
}
