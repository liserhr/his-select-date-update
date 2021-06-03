package com.dateupdate.com.springmvc.service.api;

import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.Lnrsf;


public interface LnrsfService {
    Lnrsf getLnrsfInfo(String id);

    String getLnrsfXml(String id );

    String sendLnrsfXml(String id);

    String test(String id );
}
