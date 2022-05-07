package com.acat.config;

import com.acat.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/** 处理器拦截器注册*/
@Configuration//加载当前拦截器
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**配置拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截器
        HandlerInterceptor interceptor = new LoginInterceptor();
        //配置白名单
        List<String> patterns = new ArrayList<String>();
//        patterns.add("/bootstap3/**");
//        patterns.add("/css/**");
//        patterns.add("/images/**");
//        patterns.add("/js/**");
//        patterns.add("/web/index.html");
//        patterns.add("/web/login.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")//表示要拦截的url是什么
                .excludePathPatterns(patterns);//白名单，除了这些不拦截
    }
}
