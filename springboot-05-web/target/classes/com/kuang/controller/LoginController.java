package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Author 何雨铭
 * @Date 2022/11/18 22:56
 */
//好好学习，走向巅峰！
    @Controller
public class LoginController {
    @GetMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
// Model model 回显数据参数作用
//具体的业务：
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
//            return "dashboard";
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
       model.addAttribute("msg","用户名或密码错误");
       return "index";
        }

    }
//    两种注销方式
//    @RequestMapping("/user/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "redirect:/";
//    }
//
@RequestMapping("/user/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
//        request.removeAttribute("");
        return "redirect:/";
    }
}