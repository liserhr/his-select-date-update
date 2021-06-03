package com.dateupdate.com.springmvc.web;
import com.dateupdate.com.springmvc.model.DoctorImage;
import com.dateupdate.com.springmvc.service.api.DocutorQzImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocutorQzImageHandler {

    @Autowired
    private DocutorQzImageService docutorQzImageService;

    @RequestMapping("/test")
    public String test (Integer id){
        return docutorQzImageService.test(id);
    }

    @RequestMapping("/get/photo/xml")
    public String getQzPhotoXml(String id){
        return docutorQzImageService.getQzPhotoXml(id);
    }
    @RequestMapping("/send/photo/xml")
    public String sendPhotoXml(String id){
        return docutorQzImageService.sendQzPhotoXml(id);
    }
}
