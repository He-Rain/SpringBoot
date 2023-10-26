package com.kuang.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
//如果你想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配！
//扩展Springmvc  DispatcherServlet
public class MyMvcConfig implements WebMvcConfigurer {
//public interface ViewResolver  实现了视图解析器接口的类，我们就可以把它看做视图解析器。
    @Bean
    public ViewResolver MyViewResolver(){
        return new MyViewResolver();
    }
    //自定义了一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        return null;
    }
}}
