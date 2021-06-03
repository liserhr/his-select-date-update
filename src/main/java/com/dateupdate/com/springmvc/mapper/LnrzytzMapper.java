package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.Lnrzytz;
import com.dateupdate.com.springmvc.model.Lnrzytz1;
import com.dateupdate.com.springmvc.model.LnrzytzKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LnrzytzMapper {
    int deleteByPrimaryKey(LnrzytzKey key);

    int insert(Lnrzytz record);

    int insertSelective(Lnrzytz record);

    Lnrzytz selectByPrimaryKey(LnrzytzKey key);

    int updateByPrimaryKeySelective(Lnrzytz record);

    int updateByPrimaryKey(Lnrzytz record);

    List<LnrzytzKey> getInfo1(String id);

    Lnrzytz1 getInfo2(String id);
}