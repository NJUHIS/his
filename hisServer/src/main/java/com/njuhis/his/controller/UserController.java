package com.njuhis.his.controller;

import com.njuhis.his.mapper.UserMapper;
import com.njuhis.his.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user")
    public List<User> getUser(){
        return  userMapper.selectAll();
    }
}
