package com.kfm.controller;


import com.kfm.entity.UserPojo;
import com.kfm.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //实现页面跳转
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //实现用户登录
    @RequestMapping("/sign")
    public String signIn(UserPojo userPojo, Model model, HttpServletRequest request){
        UserPojo user = userService.login(userPojo);
        if(user != null){
            request.getSession().setAttribute("user",user);
            return "index";
        }else{
            model.addAttribute("msg","登陆失败！");
            return "login";
        }
    }
}
