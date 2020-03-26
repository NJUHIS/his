package com.njuhis.his.databasetest;

import com.njuhis.his.mapper.DepartmentMapper;
import com.njuhis.his.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 此類用以插入測試數據。
 * 此程序啟動後自動運行。
 */

@Component
public class TestDataInserter implements ApplicationRunner {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //TODO
    }
}
