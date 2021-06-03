package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.model.Lnrzytz;
import com.dateupdate.com.springmvc.service.api.LnrzytzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class lnrzytzHandler {

    @Autowired
    private LnrzytzService lnrzytzService;

    @RequestMapping("/get/lnrzytz/xml")
    public String getLnrzytzXml(String id  ){
        return lnrzytzService.getLnrzytzXml(id);
    }

    @RequestMapping("/send/lnrzytz/xml")
    public String sendLnrzytzXml(String id){
        return lnrzytzService.sendLnrzytzXml(id);
    }
}
