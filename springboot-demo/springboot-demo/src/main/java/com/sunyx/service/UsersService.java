package com.sunyx.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunyx.entity.Users;

public interface UsersService extends IService<Users> {

    IPage page1(IPage<Users> page);

    IPage page2(IPage<Users> page, Wrapper wrapper);


}
