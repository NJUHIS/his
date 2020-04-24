package com.njuhis.his.databasetest;

import com.njuhis.his.model.Drugs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {
    @RequestMapping("/")
    public String selectAllDrugs(){
        return "hello xjy!";
    }
}
