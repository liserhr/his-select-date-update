package com.dateupdate.com.springmvc.service.api;

import com.dateupdate.com.springmvc.model.Other;

import java.util.List;

public interface OtherService {
    List<Other> gettjh(String timestart, String timeout);
}
