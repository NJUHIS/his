package com.njuhis.his.mapper;

import com.njuhis.his.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}