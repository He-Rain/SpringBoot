package com.kuang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//自动装配
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
//        调用业务，接受前端的参数
        return  "hello,World";
    }
}
