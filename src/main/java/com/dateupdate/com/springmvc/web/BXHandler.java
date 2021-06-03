package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.service.api.BXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BXHandler {

    @Autowired
    private BXService bxService;

    @RequestMapping("/get/BX/xml")
    public String getBXxml(String id){
        return bxService.getBXxml(id);
    }
    @RequestMapping("/send/BX/xml")
    public String sendBXxml(String id){
        return bxService.sendBXxml(id);
    }
}
