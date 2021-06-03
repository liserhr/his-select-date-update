package com.dateupdate.com.springmvc.service.api;

import com.dateupdate.com.springmvc.model.UserLoginUP;

public interface LoginService {
    UserLoginUP UserLogin(String userName, String passWord);
}
