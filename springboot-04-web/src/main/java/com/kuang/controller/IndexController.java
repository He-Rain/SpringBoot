package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//在templates目录下的所有页面，只能通过@controller来跳转！
//这个需要模板引擎的支持！ thymeleaf
@Controller
public class IndexController {
    @RequestMapping("/index1")
   public  String  index(){
       return "index";

   }}
