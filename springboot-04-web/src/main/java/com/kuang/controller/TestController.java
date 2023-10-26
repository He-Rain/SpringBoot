package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class TestController {
    @RequestMapping("/test")
    String test(Model model){
        model.addAttribute("msg","<h1>hello,springboot</h1>");
        model.addAttribute("users", Arrays.asList("a","b","c"));
        return "test";
    }
}
