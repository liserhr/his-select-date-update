package com.dateupdate.com.springmvc.web;
import com.dateupdate.com.springmvc.model.DQzPhoto;
import com.dateupdate.com.springmvc.model.DoctorImage;
import com.dateupdate.com.springmvc.model.DoctorImageWithBLOBs;
import com.dateupdate.com.springmvc.service.api.DocutorQzImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DocutorQzImageHandler {

    @Autowired
    private DocutorQzImageService docutorQzImageService;

    @RequestMapping("/user/asdasd/test")
    public List<DQzPhoto> test (String id){
        return docutorQzImageService.test(id);
    }

    @RequestMapping("/user/get/photo/xml")
    public String getQzPhotoXml(String id){
        return docutorQzImageService.getQzPhotoXml(id);
    }
    @RequestMapping("/user/send/photo/xml")
    public String sendPhotoXml(String id){
        return docutorQzImageService.sendQzPhotoXml(id);
    }

    @RequestMapping("/user/send/qzphotolist/xml")
    public List<String> sendlist(@RequestParam("ids") String list){
        String[] idlist = list.split(",");
        List<String>  result = new ArrayList<String>();
        for (String id :idlist){
            String message = sendPhotoXml(id);
            result.add(id+": "+message);
        }
        return result;
    }
}
