package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.Lnrsf;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LnrsfMapper {
    int deleteByPrimaryKey(String patientNo);

    int insert(Lnrsf record);

    int insertSelective(Lnrsf record);

    Lnrsf selectByPrimaryKey(String patientNo);

    int updateByPrimaryKeySelective(Lnrsf record);

    int updateByPrimaryKey(Lnrsf record);

    Lnrsf getLnrsfInfo(String id);

    String getCard(String id);

    String getDocutorName(int id);
}