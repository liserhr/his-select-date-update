package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.BX;
import com.dateupdate.com.springmvc.model.BX1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XBMapper {

    List<BX> getXB(String id);

    BX1 Zjphoto(String id);
}
