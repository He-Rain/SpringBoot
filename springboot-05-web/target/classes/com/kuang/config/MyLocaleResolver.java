package com.kuang.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName MyLocaleResolver
 * @Author 何雨铭
 * @Date 2022/11/18 19:54
 */
//好好学习，走向巅峰！
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
       String language =request.getParameter("l");
       Locale locale=Locale.getDefault(); //如果没有就是使用默认的。
//        如果请求的链接携带了国际化的参数
        if(!StringUtils.isEmpty(language))
        {
//            zh-CN
         String[] split = language.split("_");
//         国家 地区
            locale =new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

