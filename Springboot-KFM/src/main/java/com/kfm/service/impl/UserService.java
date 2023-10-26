package com.kfm.service.impl;


import com.kfm.entity.UserPojo;
import com.kfm.mapper.UserMapper;
import com.kfm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    //用户登录
    @Override
    public UserPojo login(UserPojo userPojo) {

        return userMapper.login(userPojo);
    }
}
