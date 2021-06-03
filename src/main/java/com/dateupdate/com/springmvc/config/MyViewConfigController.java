package com.dateupdate.com.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyViewConfigController implements WebMvcConfigurer {
    @Override
    /*重写addViewControllers实现*/
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("user-login");
    }
}
