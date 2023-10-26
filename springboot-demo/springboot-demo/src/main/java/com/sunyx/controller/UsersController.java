package com.sunyx.controller;


import com.sunyx.common.Result;
import com.sunyx.entity.User;
import com.sunyx.entity.Users;
import com.sunyx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/list")
    public List<Users> list(){
        return usersService.list();
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Users users){
        return usersService.save(users)?Result.suc():Result.fail();
    }

    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Users users){
        return usersService.updateById(users)?Result.suc():Result.fail();
    }
}
