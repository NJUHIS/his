package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.CheckApplyMapper;
import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.model.CheckApply;
import com.njuhis.his.util.QuickLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 此類用以插入測試數據。
 * 此程序啟動後自動運行。
 * @author Paul
 */

@Component
public class DateTester implements ApplicationRunner {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private CheckApplyMapper checkApplyMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //TODO
    }
}
