package com.kuang.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
//如果我们要扩展springmvc，官方建议我们这样做。
@Configuration
@EnableWebMvc  //导入一个类DelegatingWebMvcConfiguration:从容器中获取所有的webmvcconfig。
//如果你想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配！
//扩展Springmvc  DispatcherServlet
public class MyMvcConfig1 implements WebMvcConfigurer {
    /**
     * Configure simple automated controllers pre-configured with the response
     * status code and/or a view to render the response body. This is useful in
     * cases where there is no need for custom controller logic -- e.g. render a
     * home page, perform simple site URL redirects, return a 404 status with
     * HTML content, a 204 with no content, and more.
     *
     * @param registry
     * @see ViewControllerRegistry
     */
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/he").setViewName("test");
    }
}
