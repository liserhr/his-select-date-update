package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.PeReportDepartmentDetailMapper;
import com.dateupdate.com.springmvc.mapper.XBMapper;
import com.dateupdate.com.springmvc.model.BX;
import com.dateupdate.com.springmvc.model.DQzPhoto;
import com.dateupdate.com.springmvc.service.api.BXService;
import com.dateupdate.com.springmvc.util.Util;
import com.dateupdate.com.webService.WebService;
import com.dateupdate.com.webService.WebServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BXServiceImpl implements BXService {

    @Autowired
    private XBMapper xbMapper;

    @Autowired
    private PeReportDepartmentDetailMapper peReportDepartmentDetailMapper;

    @Override
    public String getBXxml(String id) {
        System.out.println(id);
        Util util = new Util();
        List<BX> list  = xbMapper.getXB(id);
        if (list .size() == 0 ){
            return "没有查询到该人数据";
        }
        String zj = "";
        if (xbMapper.Zjphoto(id) != null){
            byte[]  zjphoto = xbMapper.Zjphoto(id).getImage();
            zj =
            "            <subrow name=\"T_PW_PICFILE\">  <!--拍照图片-->\n" +
                    "                <field name=\"DGrdabh\"><![CDATA[]]></field>\n" +
                    "                <field name=\"filename\"><![CDATA["+id+"pztp1]]></field>//文件名称\n" +
                    "                <field name=\"tablename\"><![CDATA[T_JK_JKTJ]]></field>//表名\n" +
                    "                <field name=\"signcolumn\"><![CDATA[pztp]]></field>文件类型名\n" +
                    "                <field name=\"picture\"><![CDATA["+Util.getImageString(zjphoto)+"]]></field>//文件64码\n" +
                    "            </subrow>"+
                    "<subrow name=\"T_PW_PICFILE\">  \n" +
                    "\t\t\t\t<field name=\"DGrdabh\"><![CDATA[]]></field>\n" +
                    "\t\t\t\t<field name=\"filename\"><![CDATA["+id+"tjbgpdf]]></field>//文件名称\n" +
                    "\t\t\t\t<field name=\"tablename\"><![CDATA[T_JK_JKTJ]]></field>//表名\n" +
                    "\t\t\t\t<field name=\"signcolumn\"><![CDATA[tjbgpdf]]></field>文件类型名\n" +
                    "\t\t\t\t<field name=\"picture\"><![CDATA["+Util.getImageString(zjphoto)+"]]></field>//文件64码\n" +
                    "\t\t\t</subrow>";
        }else {
            zj = "";
        }
        String xml ="<XMLTOPERSONS return=\"TRUE\" biaoshi=\"2\" value=\"0\" username=\"370705B100090012\"  prgid=\"370705B10009\">\n" +
                "<row name=\"T_DA_JKDA_RKXZL\">\n" +
                "<field name=\"DSfzh\"><![CDATA["+peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no()+"]]></field>//身份证\n" +
                "<field name=\"jkbs\"><![CDATA[1]]></field>\n" +
                "<subrow name=\"T_JK_JKTJ\">\n" +
                "\n" +
                "<field name=\"happentime\"><![CDATA["+util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date())+"]]></field>\n" +
                util.bx(list,id)+
               zj+
                "        </subrow>\n" +
                "        </row>\n" +
                "        </XMLTOPERSONS>";
        return xml;
    }

    @Override
    public String sendBXxml(String id) {
        System.out.println(id);
        Util util = new Util();
        List<BX> list  = xbMapper.getXB(id);
        if (list.size() == 0){
            return "没有查询到该人数据";
        }
        String zj = "";
        if (xbMapper.Zjphoto(id) != null){
            byte[]  zjphoto = xbMapper.Zjphoto(id).getImage();
            zj =
                    "            <subrow name=\"T_PW_PICFILE\">  <!--拍照图片-->\n" +
                            "                <field name=\"DGrdabh\"><![CDATA[]]></field>\n" +
                            "                <field name=\"filename\"><![CDATA["+id+"pztp 1]]></field>//文件名称\n" +
                            "                <field name=\"tablename\"><![CDATA[T_JK_JKTJ]]></field>//表名\n" +
                            "                <field name=\"signcolumn\"><![CDATA[pztp]]></field>文件类型名\n" +
                            "                <field name=\"picture\"><![CDATA["+Util.getImageString(zjphoto)+"]]></field>//文件64码\n" +
                            "            </subrow>"+
                            "<subrow name=\"T_PW_PICFILE\">  \n" +
                            "\t\t\t\t<field name=\"DGrdabh\"><![CDATA[]]></field>\n" +
                            "\t\t\t\t<field name=\"filename\"><![CDATA["+id+"tjbgpdf]]></field>//文件名称\n" +
                            "\t\t\t\t<field name=\"tablename\"><![CDATA[T_JK_JKTJ]]></field>//表名\n" +
                            "\t\t\t\t<field name=\"signcolumn\"><![CDATA[tjbgpdf]]></field>文件类型名\n" +
                            "\t\t\t\t<field name=\"picture\"><![CDATA["+Util.getImageString(zjphoto)+"]]></field>//文件64码\n" +
                            "\t\t\t</subrow>";

        }else {
            zj = "";
        }
        String xml ="<XMLTOPERSONS return=\"TRUE\" biaoshi=\"2\" value=\"0\" username=\"370705B100090012\"  prgid=\"370705B10009\">\n" +
                "<row name=\"T_DA_JKDA_RKXZL\">\n" +
                "<field name=\"DSfzh\"><![CDATA["+peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no()+"]]></field>//身份证\n" +
                "<field name=\"jkbs\"><![CDATA[1]]></field>\n" +
                "<subrow name=\"T_JK_JKTJ\">\n" +
                "\n" +
                "<field name=\"happentime\"><![CDATA["+util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date())+"]]></field>\n" +
                util.bx(list,id)+
                zj+
                "        </subrow>\n" +
                "        </row>\n" +
                "        </XMLTOPERSONS>";

        WebService factory =  new WebService();
        WebServicePortType webServiceHttpPort = factory.getWebServiceHttpPort();
        String hello = webServiceHttpPort.dataCenterWebservice("3B86EDC086794717A76AAD14ED0A0AA6","92bf9d5c1a324227932cb271dbfd7005",xml);
        return hello;
    }
}
