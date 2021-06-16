package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.DoctorImageMapper;
import com.dateupdate.com.springmvc.mapper.PeReportDepartmentDetailMapper;
import com.dateupdate.com.springmvc.model.DQzPhoto;
import com.dateupdate.com.springmvc.model.DoctorImageWithBLOBs;
import com.dateupdate.com.springmvc.model.Qzbr;
import com.dateupdate.com.springmvc.service.api.DocutorQzImageService;
import com.dateupdate.com.springmvc.util.Util;
import com.dateupdate.com.webService.WebService;
import com.dateupdate.com.webService.WebServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocutorQzImageImpl implements DocutorQzImageService {

    @Autowired
    private DoctorImageMapper doctorImageMapper;

    @Autowired
    private PeReportDepartmentDetailMapper peReportDepartmentDetailMapper;



    @Override
    public List<DQzPhoto> test(String id) {
        List<DQzPhoto> list = doctorImageMapper.getQzPhoto(id);
        return list;
    }

    @Override
    public String getQzPhotoXml(String id) {
        System.out.println(id);
        Util util = new Util();
        // 首先查询出你出想要的数据
        List<DQzPhoto> list = doctorImageMapper.getQzPhoto(id);
        List<Qzbr> list1 = doctorImageMapper.Qzbr(id);
        if (list.size() == 0 && list1.size() == 0 ){
            return "没有查询到该数据";
        }
        // 将查询的数据经过util或者字符串拼接生成想要的xml
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "<XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                    "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                    "        <field name=\"DSfzh\">"+peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no()+"</field>\n" +
                    "        <subrow name=\"T_JK_JKTJ\">\n" +
                    "            <field name=\"happentime\">"+util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date())+"</field>\n" +
                    "            <field name=\"createtime\">"+util.Datesfm(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date())+"</field>\n" +
                    "            \n" +util.PhotoXml(list)+util.Qzbr(list1)+
                    "        </subrow>\n" +
                    "    </row>\n" +
                    "</XMLTOPERSONS>";
        // 最终将生成的xml返回回来
        return xml;
    }

    @Override
    public String sendQzPhotoXml(String id) {
        System.out.println(id);
        Util util = new Util();
        // 首先查询出你出想要的数据
        List<DQzPhoto> list = doctorImageMapper.getQzPhoto(id);
        List<Qzbr> list1 = doctorImageMapper.Qzbr(id);
        if (list.size() == 0 && list1.size() == 0 ){
            return "没有查询到该人数据";
        }
        // 将查询的数据经过util或者字符串拼接生成想要的xml
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                "        <field name=\"DSfzh\">"+peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no()+"</field>\n" +
                "        <subrow name=\"T_JK_JKTJ\">\n" +
                "            <field name=\"happentime\">"+util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date())+"</field>\n" +
                "            <field name=\"createtime\">"+util.Datesfm(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date())+"</field>\n" +
                "            \n" +util.PhotoXml(list)+util.Qzbr(list1)+
                "        </subrow>\n" +
                "    </row>\n" +
                "</XMLTOPERSONS>";
        // 最终将生成的xml返回回来
        WebService factory =  new WebService();
        WebServicePortType webServiceHttpPort = factory.getWebServiceHttpPort();
        String hello = webServiceHttpPort.dataCenterWebservice("3B86EDC086794717A76AAD14ED0A0AA6","8360CEA8EA8F476F91F861562F6938FF",xml);
        return hello;
    }


}
