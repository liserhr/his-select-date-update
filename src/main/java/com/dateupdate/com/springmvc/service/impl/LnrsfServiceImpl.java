package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.LnrsfMapper;
import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.Lnrsf;
import com.dateupdate.com.springmvc.service.api.LnrsfService;
import com.dateupdate.com.springmvc.util.Util;
import com.dateupdate.com.webService.WebService;
import com.dateupdate.com.webService.WebServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LnrsfServiceImpl implements LnrsfService {

    @Autowired
    private LnrsfMapper lnrsfMapper;

    Util util =  new Util();


    @Override
    public Lnrsf getLnrsfInfo(String id) {
        return lnrsfMapper.getLnrsfInfo(id);
    }

    @Override
    public String getLnrsfXml(String id) {
        Lnrsf list = getLnrsfInfo(id);
        if (list == null ){
            return "没有查询到该人老年人中医体质数据";
        }
        if (list !=null ){
            int number = util.xmlLnrsf(list, 1) +util.xmlLnrsf(list, 2) +util.xmlLnrsf(list, 3) +util.xmlLnrsf(list, 4) +util.xmlLnrsf(list, 5);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                "        <field name=\"DSfzh\">" + test(id) + "</field>\n" +
                "        <subrow name=\"T_JG_LNRSF\">//老年人随访信息表\n" +
                "            <field name=\"jcpf\"><![CDATA[" + util.xmlLnrsf(list, 1) + "]]></field>//进餐评分\n" +
                "            <field name=\"sxpf\"><![CDATA[" + util.xmlLnrsf(list, 2) + "]]></field>//梳洗评分\n" +
                "            <field name=\"cypf\"><![CDATA[" + util.xmlLnrsf(list, 3) + "]]></field>//穿衣评分\n" +
                "            <field name=\"rcpf\"><![CDATA[" + util.xmlLnrsf(list, 4) + "]]></field>//如厕评分\n" +
                "            <field name=\"hdpf\"><![CDATA[" + util.xmlLnrsf(list, 5) + "]]></field>//活动评分\n" +
                "            <field name=\"zpf\"><![CDATA["  + number + "]]></field>//总评分\n" +
                "            <field name=\"happentime\"><![CDATA[" + util.Datenyr(list.getOperateDate()) + "]]></field>//填表时间\n" +
                "            <field name=\"GSfys\"><![CDATA[" + getDocutorName(getLnrsfInfo(id).getOperatorId()) + "]]></field>//医生签名\n" +
                "            <field name=\"GXcsfmb\"><![CDATA[" + "体检合格"+ "]]></field>\n" +
                "        </subrow>\n" +
                "        //下次随访目标\n" +
                "    </row>\n" +
                "</XMLTOPERSONS>       ";
        return xml;
    }else{
            return "没有查询到你输入的id的相关信息。";
        }
    }

    @Override
    public String sendLnrsfXml(String id) {
        Lnrsf list = getLnrsfInfo(id);
        if (list == null ){
            return "没有查询到该人老年人中医体质数据";
        }
        if (list!= null){
            int number = util.xmlLnrsf(list, 1) +util.xmlLnrsf(list, 2) +util.xmlLnrsf(list, 3) +util.xmlLnrsf(list, 4) +util.xmlLnrsf(list, 5);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                "        <field name=\"DSfzh\">" + test(id) + "</field>\n" +
                "        <subrow name=\"T_JG_LNRSF\">//老年人随访信息表\n" +
                "            <field name=\"jcpf\"><![CDATA[" + util.xmlLnrsf(list, 1) + "]]></field>//进餐评分\n" +
                "            <field name=\"sxpf\"><![CDATA[" + util.xmlLnrsf(list, 2) + "]]></field>//梳洗评分\n" +
                "            <field name=\"cypf\"><![CDATA[" + util.xmlLnrsf(list, 3) + "]]></field>//穿衣评分\n" +
                "            <field name=\"rcpf\"><![CDATA[" + util.xmlLnrsf(list, 4) + "]]></field>//如厕评分\n" +
                "            <field name=\"hdpf\"><![CDATA[" + util.xmlLnrsf(list, 5) + "]]></field>//活动评分\n" +
                "            <field name=\"zpf\"><![CDATA["  + number + "]]></field>//总评分\n" +
                "            <field name=\"happentime\"><![CDATA[" + util.Datenyr(list.getOperateDate()) + "]]></field>//填表时间\n" +
                "            <field name=\"GSfys\"><![CDATA[" + getDocutorName(getLnrsfInfo(id).getOperatorId()) + "]]></field>//医生签名\n" +
                "            <field name=\"GXcsfmb\"><![CDATA[" + "体检合格"+ "]]></field>\n" +
                "        </subrow>\n" +
                "        //下次随访目标\n" +
                "    </row>\n" +
                "</XMLTOPERSONS>       ";

        WebService factory = new WebService();
        WebServicePortType webServiceHttpPort = factory.getWebServiceHttpPort();
        String hello = webServiceHttpPort.dataCenterWebservice("3B86EDC086794717A76AAD14ED0A0AA6", "816a29bf4e414fe28fc1f1b1da29fcf6", xml);
        return hello;
    }else{
            return "根据id没有找到该用户的信息，请确认id是否输入正确";
        }
    }

    // 这个方法用法国来获得该病人的身份证号码
    @Override
    public String test(String id) {
        return lnrsfMapper.getCard(id);
    }

    // 该方法用来获得该病人就诊医生的名字
    public String getDocutorName(int dId){
        return  lnrsfMapper.getDocutorName(dId);
    }
}
