package com.kfm.service;


import com.kfm.entity.UserPojo;

public interface IUserService {
    //登录
    public UserPojo login(UserPojo userPojo);
}
