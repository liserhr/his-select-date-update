package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.UserLoginMapper;
import com.dateupdate.com.springmvc.model.UserLoginUP;
import com.dateupdate.com.springmvc.service.api.LoginService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLoginUP UserLogin(String username, String passsord) {
        System.out.println(username);
        UserLoginUP up  = userLoginMapper.selectPassword(username);
        if (up == null){
            return null;
        } else {
            if (up.getPassword().equals(passsord)){
                return  up;
            }else {
                return null;
            }
        }

    }
}
