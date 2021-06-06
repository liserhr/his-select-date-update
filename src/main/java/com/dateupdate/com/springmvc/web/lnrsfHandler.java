package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.Lnrsf;
import com.dateupdate.com.springmvc.service.api.LnrsfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class lnrsfHandler {

    @Autowired
    private LnrsfService lnrsfService;

    @RequestMapping("/user/get/lnrsf/info")
    public Lnrsf getLnrsfInfo(String id){
        return lnrsfService.getLnrsfInfo(id);
    }

    @RequestMapping("/user/get/lnrsf/xml")
    public String getLnfsfXml(String id){
        return lnrsfService.getLnrsfXml(id);
    }

    @RequestMapping("/user/send/lnrsf/xml")
    public String sendLnrsfXml(String id ){
        return lnrsfService.sendLnrsfXml(id);
    }

    @RequestMapping("/user/lnrsf/test")
    public String test(String id ){
        return lnrsfService.test(id);
    }

    @RequestMapping("/user/send/lnrsflist/xml")
    public List<String> sendlist(@RequestParam("ids") String list){
        String[] idlist = list.split(",");
        List<String>  result = new ArrayList<String>();
        for (String id :idlist){
            String message = sendLnrsfXml(id);
            result.add(id+": "+message);
        }
        return result;
    }
}
