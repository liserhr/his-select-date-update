package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.Lnrsf;
import com.dateupdate.com.springmvc.service.api.LnrsfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class lnrsfHandler {

    @Autowired
    private LnrsfService lnrsfService;

    @RequestMapping("/get/lnrsf/info")
    public Lnrsf getLnrsfInfo(String id){
        return lnrsfService.getLnrsfInfo(id);
    }

    @RequestMapping("/get/lnrsf/xml")
    public String getLnfsfXml(String id){
        return lnrsfService.getLnrsfXml(id);
    }

    @RequestMapping("/send/lnrsf/xml")
    public String sendLnrsfXml(String id ){
        return lnrsfService.sendLnrsfXml(id);
    }

    @RequestMapping("/lnrsf/test")
    public String test(String id ){
        return lnrsfService.test(id);
    }
}
