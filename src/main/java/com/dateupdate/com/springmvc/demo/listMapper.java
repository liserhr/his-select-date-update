package com.dateupdate.com.springmvc.demo;

import com.dateupdate.com.springmvc.demo.list;
import com.dateupdate.com.springmvc.demo.listKey;

public interface listMapper {
    int deleteByPrimaryKey(listKey key);

    int insert(list record);

    int insertSelective(list record);

    list selectByPrimaryKey(listKey key);

    int updateByPrimaryKeySelective(list record);

    int updateByPrimaryKeyWithBLOBs(list record);

    int updateByPrimaryKey(list record);
}