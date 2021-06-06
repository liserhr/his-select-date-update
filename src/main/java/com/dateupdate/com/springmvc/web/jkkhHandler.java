package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.service.api.JkkhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jkkhHandler {

    @Autowired
    private JkkhService jkkhService;

    @RequestMapping("/user/get/jkkh/xml")
    public String getJkkh(String id){
        return jkkhService.getJkkh(id);
    }
}
