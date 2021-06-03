package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.ListOne;
import com.dateupdate.com.springmvc.model.PeReportDepartmentDetail;
import com.dateupdate.com.springmvc.model.PeReportDepartmentDetailKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface PeReportDepartmentDetailMapper {
    int deleteByPrimaryKey(PeReportDepartmentDetailKey key);

    int insert(PeReportDepartmentDetail record);

    int insertSelective(PeReportDepartmentDetail record);

    PeReportDepartmentDetail selectByPrimaryKey(PeReportDepartmentDetailKey key);

    int updateByPrimaryKeySelective(PeReportDepartmentDetail record);

    int updateByPrimaryKey(PeReportDepartmentDetail record);

    List<ListOne> selectForListOne(String parientNo);

    String getDocutorId(String id);

    String getDocutor(String id);

    CardTimeDocutor getPersionCardTime(String id);

    Date getTest(String id);

    String getDoctorName(String id);


}