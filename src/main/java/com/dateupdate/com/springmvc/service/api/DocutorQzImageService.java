package com.dateupdate.com.springmvc.service.api;

import com.dateupdate.com.springmvc.model.DoctorImage;

public interface DocutorQzImageService {
    String test(Integer id);

    String getQzPhotoXml(String id);

    String sendQzPhotoXml(String id);
}
