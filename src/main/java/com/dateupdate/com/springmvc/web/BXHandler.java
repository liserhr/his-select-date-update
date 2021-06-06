package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.service.api.BXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BXHandler {

    @Autowired
    private BXService bxService;

    @RequestMapping("/user/get/BX/xml")
    public String getBXxml(String id){
        return bxService.getBXxml(id);
    }
    @RequestMapping("/user/send/BX/xml")
    public String sendBXxml(String id){
        return bxService.sendBXxml(id);
    }

    @RequestMapping("/user/send/bxphotolist/xml")
    public List<String> sendlist(@RequestParam("ids") String list){
        String[] idlist = list.split(",");
        List<String>  result = new ArrayList<String>();
        for (String id :idlist){
            String message = sendBXxml(id);
            result.add(id+": "+message);
        }
        return result;
    }
}
