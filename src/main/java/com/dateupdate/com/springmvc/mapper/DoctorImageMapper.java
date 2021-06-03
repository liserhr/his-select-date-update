package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.DQzPhoto;
import com.dateupdate.com.springmvc.model.DoctorImage;
import com.dateupdate.com.springmvc.model.DoctorImageWithBLOBs;
import com.dateupdate.com.springmvc.model.Qzbr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorImageMapper {
    int deleteByPrimaryKey(Integer personId);

    int insert(DoctorImageWithBLOBs record);

    int insertSelective(DoctorImageWithBLOBs record);

    DoctorImageWithBLOBs selectByPrimaryKey(Integer personId);

    int updateByPrimaryKeySelective(DoctorImageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DoctorImageWithBLOBs record);

    int updateByPrimaryKey(DoctorImage record);


    List<DQzPhoto> getQzPhoto(String id);

    List<Qzbr> Qzbr(String id );
}