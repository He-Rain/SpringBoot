package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHanderInterceptor
 * @Author 何雨铭
 * @Date 2022/11/20 8:45
 */
//好好学习，走向巅峰！
//  拦截器
public class LoginHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //   登陆成功之后，应该有用户的session.
      Object  loginUser  =request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false; //true放行 false不放行。
        }else
//        return HandlerInterceptor.super.preHandle(request, response, handler);
 return true; //true放行 false不放行。
}}
