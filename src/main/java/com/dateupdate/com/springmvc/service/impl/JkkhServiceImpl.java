package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.JkkhMapper;
import com.dateupdate.com.springmvc.model.SfName;
import com.dateupdate.com.springmvc.service.api.JkkhService;
import com.dateupdate.com.webService.WebService;
import com.dateupdate.com.webService.WebServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JkkhServiceImpl implements JkkhService {

    @Autowired
    private JkkhMapper jkkhMapper;



    @Override
    public String getJkkh(String id) {
        SfName sf = jkkhMapper.getSf(id);
String xml = "<XMLTOPERSONS return=\"TRUE\" value=\"0\" username=\"370705B100090012\" password =\"q123963*\" prgid=\"370705B10009\">\n" +
        "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
        "        <field name=\"DXm\"><![CDATA["+sf.getUserName()+"]]></field>  //姓名（必填）\n" +
        "        <field name=\"DSfzh\"><![CDATA["+sf.getSfNumber()+"]]></field>  //身份证号（必填）\n" +
        "    </row>\n" +
        "</XMLTOPERSONS>";

        WebService factory =  new WebService();
        WebServicePortType webServiceHttpPort = factory.getWebServiceHttpPort();
        String hello = webServiceHttpPort.dataCenterWebservice("3B86EDC086794717A76AAD14ED0A0AA6","645f9b7b405141b789359086ab5860d0",xml);
        return hello;
    }
}
