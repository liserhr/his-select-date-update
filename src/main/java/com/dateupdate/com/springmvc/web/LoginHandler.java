package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.model.UserLoginUP;
import com.dateupdate.com.springmvc.service.api.LoginService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LoginHandler {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/user/login")
    public String Login(){
        return "user-login";
    }



    @PostMapping(value = "/user/login")
    public String UserLogin(@RequestParam("UserName") String UserName, @RequestParam("PassWord") String PassWord, Model model){
        UserLoginUP up = loginService.UserLogin(UserName,PassWord);
            if (up == null ){
                model.addAttribute("message","您输入的账户或者密码有错误");
                return "user-login";
            }else{
                model.addAttribute("name",up.getName());
                return "user-main";
            }

    }
}
