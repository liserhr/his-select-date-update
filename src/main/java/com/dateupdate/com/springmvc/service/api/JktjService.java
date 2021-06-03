package com.dateupdate.com.springmvc.service.api;


import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.ListOne;

import java.util.Date;
import java.util.List;

public interface JktjService {
      List<ListOne> getById(String id);

    String getXml(String id );

    String sendXml(String id);

    CardTimeDocutor getTest(String id);
}
