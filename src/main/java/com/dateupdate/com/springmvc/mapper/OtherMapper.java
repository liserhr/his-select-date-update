package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.Other;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OtherMapper {
    List<Other> gettjh(String timestart, String timeout);
}
