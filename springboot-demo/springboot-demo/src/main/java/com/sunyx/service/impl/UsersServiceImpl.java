package com.sunyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunyx.entity.Users;
import com.sunyx.mapper.UsersMapper;
import com.sunyx.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper , Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public IPage page1(IPage<Users> page) {
        return usersMapper.page1((Page<Users>) page);
    }

    @Override
    public IPage page2(IPage<Users> page, Wrapper wrapper) {
        return usersMapper.page2(page,wrapper);
    }

}
