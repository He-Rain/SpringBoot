package com.kfm.mapper;


import com.kfm.entity.UserPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //登录
    public UserPojo login(UserPojo userPojo);
}
