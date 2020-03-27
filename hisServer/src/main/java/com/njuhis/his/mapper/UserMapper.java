package com.njuhis.his.mapper;

import com.njuhis.his.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserName(String username);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}