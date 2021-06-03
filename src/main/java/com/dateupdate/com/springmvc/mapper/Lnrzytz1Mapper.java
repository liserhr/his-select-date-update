package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.Lnrzytz1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Lnrzytz1Mapper {
    int deleteByPrimaryKey(String patientNo);

    int insert(Lnrzytz1 record);

    int insertSelective(Lnrzytz1 record);

    Lnrzytz1 selectByPrimaryKey(String patientNo);

    int updateByPrimaryKeySelective(Lnrzytz1 record);

    int updateByPrimaryKey(Lnrzytz1 record);
}