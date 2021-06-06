package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.OtherMapper;
import com.dateupdate.com.springmvc.model.Other;
import com.dateupdate.com.springmvc.service.api.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherMapper otherMapper;
    @Override
    public List<Other> gettjh(String timestart, String timeout) {
        return  otherMapper.gettjh(timestart,timeout);
    }
}
