package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.ListOne;
import com.dateupdate.com.springmvc.service.api.JktjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JktjHandler {

    @Autowired
    private JktjService jktjService;


    // 此方法用来获数据库里面的值
    @RequestMapping("/user/get/jktj/info")
    public List<ListOne> getById(String id){
        return jktjService.getById(id);
    }

    // 这个方法用来生成健康体检的xml
    @RequestMapping("/user/get/jktj/xml")
    public String getXml(String id){
        String xml = jktjService.getXml(id);
        return xml;
    }

    @RequestMapping("/user/get/test")
    public CardTimeDocutor getTest(String id){

        return  jktjService.getTest(id);
    }
    // 这个方法是将生成的xml发送到指定端口
    @RequestMapping("/user/send/jktj/xml")
    public String  sendXml(@RequestParam("id") String id){
        return jktjService.sendXml(id);
    }

    @RequestMapping("/user/send/jktjlist/xml")
    public List<String> sendlist(@RequestParam("ids") String list){
        String[] idlist = list.split(",");
        List<String>  result = new ArrayList<String>();
        for (String id :idlist){
            String message = sendXml(id);
            result.add(id+": "+message);
        }
        return result;
    }

}
