package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.SfName;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JkkhMapper {

    SfName getSf(String id);
}
