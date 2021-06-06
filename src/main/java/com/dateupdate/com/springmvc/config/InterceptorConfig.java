package com.dateupdate.com.springmvc.config;

import com.dateupdate.com.springmvc.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

    //mvc:interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //要拦截user下面额所有访问请求，必须用户登录后才可以访问，但是这样拦截的路径中有一些是不需要用户登录也可以访问的
        String[]  addPathPatterns =  {
                "/user/**"
        };
        //要从上面的路径中排除的路径，不需要用户登录也可以访问的
        String[] excludePathPatterns = {
                "/user/out","/user/error","/user/login"
        };


        //mvc:interceptor
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);



    }
}
