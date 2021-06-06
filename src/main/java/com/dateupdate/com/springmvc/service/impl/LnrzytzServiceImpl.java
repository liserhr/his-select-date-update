package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.LnrzytzMapper;
import com.dateupdate.com.springmvc.mapper.PeReportDepartmentDetailMapper;
import com.dateupdate.com.springmvc.model.ListOne;
import com.dateupdate.com.springmvc.model.Lnrzytz;
import com.dateupdate.com.springmvc.model.Lnrzytz1;
import com.dateupdate.com.springmvc.model.LnrzytzKey;
import com.dateupdate.com.springmvc.service.api.LnrzytzService;
import com.dateupdate.com.springmvc.util.Util;
import com.dateupdate.com.webService.WebService;
import com.dateupdate.com.webService.WebServicePortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LnrzytzServiceImpl implements LnrzytzService {

    @Autowired
    private LnrzytzMapper lnrzytzMapper;

    @Autowired
    private PeReportDepartmentDetailMapper peReportDepartmentDetailMapper;

    public List<LnrzytzKey> getInfo1(String id){
        return lnrzytzMapper.getInfo1(id);
    }

    public Lnrzytz1 getInfo2(String id){
        return lnrzytzMapper.getInfo2(id);
    }

    // 用来查询体检表格中有没有气虚质
    public List<ListOne> getBS(String id) {
        List<ListOne> a =  peReportDepartmentDetailMapper.selectForListOne(id);
        return a;
    }

    @Override
    public String getLnrzytzXml(String id) {
        Util util = new Util();
        List<LnrzytzKey> list = getInfo1(id);
        List<ListOne> list1 =  getBS(id);

        if (list.size() == 0 || list == null ){
            Lnrzytz1 lnrzytz = getInfo2(id);
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "        <XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                    "            <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                    "                <field name=\"DSfzh\">" + peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no() + "</field>\n" +
                    "        <subrow name=\"T_LNR_ZYYTZGL\">//老年人中医体质\n" +
                    "            <field name=\"Ljl\"><![CDATA[]]></field>//(1)精力\n" +
                    "            <field name=\"Ltl\"><![CDATA[]]></field>//(2)体力\n" +
                    "            <field name=\"Lhx\"><![CDATA[]]></field>//(3)呼吸短促\n" +
                    "            <field name=\"Lsh\"><![CDATA[]]></field>//(4)说话\n" +
                    "            <field name=\"Lxq\"><![CDATA[]]></field>//(5)心情\n" +
                    "            <field name=\"Ljzjl\"><![CDATA[]]></field>//(6)精神紧张、焦虑不安\n" +
                    "            <field name=\"Lshztgb\"><![CDATA[]]></field>//(7)生活状态改变\n" +
                    "            <field name=\"Lhpjx\"><![CDATA[]]></field>//(8)害怕或惊吓\n" +
                    "            <field name=\"Lstcz\"><![CDATA[]]></field>//(9)身体超重\n" +
                    "            <field name=\"Lyjgs\"><![CDATA[]]></field>//(10)眼睛干涩\n" +
                    "            <field name=\"Lsjfl\"><![CDATA[]]></field>//(11)手脚发凉\n" +
                    "            <field name=\"Lwwbyx\"><![CDATA[]]></field>//(12)胃脘部、背部或腰膝部怕冷\n" +
                    "            <field name=\"Lsblhl\"><![CDATA[]]></field>//(13)受不了寒冷\n" +
                    "            <field name=\"Lrygm\"><![CDATA[]]></field>//(14)容易患感冒\n" +
                    "            <field name=\"Lbslbt\"><![CDATA[]]></field>//(15)没有感冒鼻塞、流鼻涕\n" +
                    "            <field name=\"Lknndh\"><![CDATA[]]></field>//(16)口粘口腻或睡眠打鼾\n" +
                    "            <field name=\"Lgm\"><![CDATA[]]></field>//(17)容易过敏\n" +
                    "            <field name=\"Lxmz\"><![CDATA[]]></field>//(18)皮肤容易起荨麻疹\n" +
                    "            <field name=\"Lpfqzcx\"><![CDATA[]]></field>//(19)皮肤在不知不觉中会出现青紫瘀斑、皮下出血\n" +
                    "            <field name=\"Lpfhhfy\"><![CDATA[]]></field>//(20)皮肤一抓就红，并出现抓痕\n" +
                    "            <field name=\"Lpfkcg\"><![CDATA[]]></field>//(21)皮肤或口唇干\n" +
                    "            <field name=\"Lztmmtt\"><![CDATA[]]></field>//(22)肢体麻木或固定部位疼痛\n" +
                    "            <field name=\"Lynyl\"><![CDATA[]]></field>//(23)面部或鼻部有油腻感或者油亮发光\n" +
                    "            <field name=\"Lmsmk\"><![CDATA[]]></field>//(24)面色或目眶晦黯，或出现褐色斑块/斑点\n" +
                    "            <field name=\"Lpfszcj\"><![CDATA[]]></field>//(25)皮肤湿疹、疮疖\n" +
                    "            <field name=\"Lkgyzhs\"><![CDATA[]]></field>//(26)口干咽燥、总想喝水\n" +
                    "            <field name=\"Lkkkc\"><![CDATA[]]></field>//(27)口苦或嘴里有异味\n" +
                    "            <field name=\"Lfbfd\"><![CDATA[]]></field>//(28)腹部肥大\n" +
                    "            <field name=\"Lbxhls\"><![CDATA[]]></field>//(29)吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西\n" +
                    "            <field name=\"Ldbnz\"><![CDATA[]]></field>//(30)大便黏滞\n" +
                    "            <field name=\"Ldbgz\"><![CDATA[]]></field>//(31)大便干燥\n" +
                    "            <field name=\"Lsthn\"><![CDATA[]]></field>//(32)舌苔厚腻\n" +
                    "            <field name=\"Lsxjmyz\"><![CDATA[]]></field>//(33)舌下静脉瘀紫或增粗\n" +
                    "            <field name=\"Lphdf\"><![CDATA[" + lnrzytz.getAbnormityId1() + "]]></field>//平和质得分\n" +
                    "            <field name=\"Lphbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9200") + "]]></field>//平和质辨识\n" +
                    "            <field name=\"Lqxdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气虚质得分\n" +
                    "            <field name=\"Lqxbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9201") + "]]></field>//气虚质辨识\n" +
                    "            <field name=\"Lyangdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阳虚质得分\n" +
                    "            <field name=\"Lyangbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9202") + "]]></field>//阳虚质辨识\n" +
                    "            <field name=\"Lyindf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阴虚质得分\n" +
                    "            <field name=\"Lyinbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9203") + "]]></field>//阴虚质辨识\n" +
                    "            <field name=\"Ltsdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//痰湿质得分\n" +
                    "            <field name=\"Ltsbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9204") + "]]></field>//痰湿质辨识\n" +
                    "            <field name=\"Lsrdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//湿热质得分\n" +
                    "            <field name=\"Lsrbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9205") + "]]></field>//湿热质辨识\n" +
                    "            <field name=\"Lxydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//血瘀质得分\n" +
                    "            <field name=\"Lxybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9206") + "]]></field>//血瘀质辨识\n" +
                    "            <field name=\"Lqydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气郁质得分\n" +
                    "            <field name=\"Lqybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9207") + "]]></field>//气郁质辨识\n" +
                    "            <field name=\"Ltbdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//特禀质得分\n" +
                    "            <field name=\"Ltbbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9208") + "]]></field>/特禀质辨识\n" +
                    "            <field name=\"happentime\"><![CDATA[" + util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date()) + "]]></field>//填表日期\n" +
                    "            <field name=\"ysqm\"><![CDATA[" + peReportDepartmentDetailMapper.getDoctorName(id) + "]]></field>//医生签名\n" +
                    "        </subrow>\n" +
                    "            </row>\n" +
                    "</XMLTOPERSONS>";
            return xml;
        }else {
            Lnrzytz1 lnrzytz = getInfo2(id);

            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "        <XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                    "            <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                    "                <field name=\"DSfzh\">" + peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no() + "</field>\n" +
                    "        <subrow name=\"T_LNR_ZYYTZGL\">//老年人中医体质\n" +
                    "            <field name=\"Ljl\"><![CDATA[" + list.get(0).getAnswer() + "]]></field>//(1)精力\n" +
                    "            <field name=\"Ltl\"><![CDATA[" + list.get(1).getAnswer() + "]]></field>//(2)体力\n" +
                    "            <field name=\"Lhx\"><![CDATA[" + list.get(2).getAnswer() + "]]></field>//(3)呼吸短促\n" +
                    "            <field name=\"Lsh\"><![CDATA[" + list.get(3).getAnswer() + "]]></field>//(4)说话\n" +
                    "            <field name=\"Lxq\"><![CDATA[" + list.get(4).getAnswer() + "]]></field>//(5)心情\n" +
                    "            <field name=\"Ljzjl\"><![CDATA[" + list.get(5).getAnswer() + "]]></field>//(6)精神紧张、焦虑不安\n" +
                    "            <field name=\"Lshztgb\"><![CDATA[" + list.get(6).getAnswer() + "]]></field>//(7)生活状态改变\n" +
                    "            <field name=\"Lhpjx\"><![CDATA[" + list.get(7).getAnswer() + "]]></field>//(8)害怕或惊吓\n" +
                    "            <field name=\"Lstcz\"><![CDATA[" + list.get(8).getAnswer() + "]]></field>//(9)身体超重\n" +
                    "            <field name=\"Lyjgs\"><![CDATA[" + list.get(9).getAnswer() + "]]></field>//(10)眼睛干涩\n" +
                    "            <field name=\"Lsjfl\"><![CDATA[" + list.get(10).getAnswer() + "]]></field>//(11)手脚发凉\n" +
                    "            <field name=\"Lwwbyx\"><![CDATA[" + list.get(11).getAnswer() + "]]></field>//(12)胃脘部、背部或腰膝部怕冷\n" +
                    "            <field name=\"Lsblhl\"><![CDATA[" + list.get(12).getAnswer() + "]]></field>//(13)受不了寒冷\n" +
                    "            <field name=\"Lrygm\"><![CDATA[" + list.get(13).getAnswer() + "]]></field>//(14)容易患感冒\n" +
                    "            <field name=\"Lbslbt\"><![CDATA[" + list.get(14).getAnswer() + "]]></field>//(15)没有感冒鼻塞、流鼻涕\n" +
                    "            <field name=\"Lknndh\"><![CDATA[" + list.get(15).getAnswer() + "]]></field>//(16)口粘口腻或睡眠打鼾\n" +
                    "            <field name=\"Lgm\"><![CDATA[" + list.get(16).getAnswer() + "]]></field>//(17)容易过敏\n" +
                    "            <field name=\"Lxmz\"><![CDATA[" + list.get(17).getAnswer() + "]]></field>//(18)皮肤容易起荨麻疹\n" +
                    "            <field name=\"Lpfqzcx\"><![CDATA[" + list.get(18).getAnswer() + "]]></field>//(19)皮肤在不知不觉中会出现青紫瘀斑、皮下出血\n" +
                    "            <field name=\"Lpfhhfy\"><![CDATA[" + list.get(19).getAnswer() + "]]></field>//(20)皮肤一抓就红，并出现抓痕\n" +
                    "            <field name=\"Lpfkcg\"><![CDATA[" + list.get(20).getAnswer() + "]]></field>//(21)皮肤或口唇干\n" +
                    "            <field name=\"Lztmmtt\"><![CDATA[" + list.get(21).getAnswer() + "]]></field>//(22)肢体麻木或固定部位疼痛\n" +
                    "            <field name=\"Lynyl\"><![CDATA[" + list.get(22).getAnswer() + "]]></field>//(23)面部或鼻部有油腻感或者油亮发光\n" +
                    "            <field name=\"Lmsmk\"><![CDATA[" + list.get(23).getAnswer() + "]]></field>//(24)面色或目眶晦黯，或出现褐色斑块/斑点\n" +
                    "            <field name=\"Lpfszcj\"><![CDATA[" + list.get(24).getAnswer() + "]]></field>//(25)皮肤湿疹、疮疖\n" +
                    "            <field name=\"Lkgyzhs\"><![CDATA[" + list.get(25).getAnswer() + "]]></field>//(26)口干咽燥、总想喝水\n" +
                    "            <field name=\"Lkkkc\"><![CDATA[" + list.get(26).getAnswer() + "]]></field>//(27)口苦或嘴里有异味\n" +
                    "            <field name=\"Lfbfd\"><![CDATA[" + list.get(27).getAnswer() + "]]></field>//(28)腹部肥大\n" +
                    "            <field name=\"Lbxhls\"><![CDATA[" + list.get(28).getAnswer() + "]]></field>//(29)吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西\n" +
                    "            <field name=\"Ldbnz\"><![CDATA[" + list.get(29).getAnswer() + "]]></field>//(30)大便黏滞\n" +
                    "            <field name=\"Ldbgz\"><![CDATA[" + list.get(30).getAnswer() + "]]></field>//(31)大便干燥\n" +
                    "            <field name=\"Lsthn\"><![CDATA[" + list.get(31).getAnswer() + "]]></field>//(32)舌苔厚腻\n" +
                    "            <field name=\"Lsxjmyz\"><![CDATA[" + list.get(32).getAnswer() + "]]></field>//(33)舌下静脉瘀紫或增粗\n" +
                    "            <field name=\"Lphdf\"><![CDATA[" + lnrzytz.getAbnormityId1() + "]]></field>//平和质得分\n" +
                    "            <field name=\"Lphbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9200") + "]]></field>//平和质辨识\n" +
                    "            <field name=\"Lqxdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气虚质得分\n" +
                    "            <field name=\"Lqxbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9201") + "]]></field>//气虚质辨识\n" +
                    "            <field name=\"Lyangdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阳虚质得分\n" +
                    "            <field name=\"Lyangbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9202") + "]]></field>//阳虚质辨识\n" +
                    "            <field name=\"Lyindf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阴虚质得分\n" +
                    "            <field name=\"Lyinbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9203") + "]]></field>//阴虚质辨识\n" +
                    "            <field name=\"Ltsdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//痰湿质得分\n" +
                    "            <field name=\"Ltsbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9204") + "]]></field>//痰湿质辨识\n" +
                    "            <field name=\"Lsrdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//湿热质得分\n" +
                    "            <field name=\"Lsrbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9205") + "]]></field>//湿热质辨识\n" +
                    "            <field name=\"Lxydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//血瘀质得分\n" +
                    "            <field name=\"Lxybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9206") + "]]></field>//血瘀质辨识\n" +
                    "            <field name=\"Lqydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气郁质得分\n" +
                    "            <field name=\"Lqybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9207") + "]]></field>//气郁质辨识\n" +
                    "            <field name=\"Ltbdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//特禀质得分\n" +
                    "            <field name=\"Ltbbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9208") + "]]></field>/特禀质辨识\n" +
                    "            <field name=\"happentime\"><![CDATA[" + util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date()) + "]]></field>//填表日期\n" +
                    "            <field name=\"ysqm\"><![CDATA[" + peReportDepartmentDetailMapper.getDoctorName(id) + "]]></field>//医生签名\n" +
                    "        </subrow>\n" +
                    "            </row>\n" +
                    "</XMLTOPERSONS>";
            return xml;
        }
    }
    @Override
    public String sendLnrzytzXml(String id) {
        Util util = new Util();
        List<LnrzytzKey> list = getInfo1(id);
        List<ListOne> list1 =  getBS(id);
        if (list.size() == 0 || list == null ){
            Lnrzytz1 lnrzytz = getInfo2(id);
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "        <XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                    "            <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                    "                <field name=\"DSfzh\">" + peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no() + "</field>\n" +
                    "        <subrow name=\"T_LNR_ZYYTZGL\">//老年人中医体质\n" +
                    "            <field name=\"Ljl\"><![CDATA[]]></field>//(1)精力\n" +
                    "            <field name=\"Ltl\"><![CDATA[]]></field>//(2)体力\n" +
                    "            <field name=\"Lhx\"><![CDATA[]]></field>//(3)呼吸短促\n" +
                    "            <field name=\"Lsh\"><![CDATA[]]></field>//(4)说话\n" +
                    "            <field name=\"Lxq\"><![CDATA[]]></field>//(5)心情\n" +
                    "            <field name=\"Ljzjl\"><![CDATA[]]></field>//(6)精神紧张、焦虑不安\n" +
                    "            <field name=\"Lshztgb\"><![CDATA[]]></field>//(7)生活状态改变\n" +
                    "            <field name=\"Lhpjx\"><![CDATA[]]></field>//(8)害怕或惊吓\n" +
                    "            <field name=\"Lstcz\"><![CDATA[]]></field>//(9)身体超重\n" +
                    "            <field name=\"Lyjgs\"><![CDATA[]]></field>//(10)眼睛干涩\n" +
                    "            <field name=\"Lsjfl\"><![CDATA[]]></field>//(11)手脚发凉\n" +
                    "            <field name=\"Lwwbyx\"><![CDATA[]]></field>//(12)胃脘部、背部或腰膝部怕冷\n" +
                    "            <field name=\"Lsblhl\"><![CDATA[]]></field>//(13)受不了寒冷\n" +
                    "            <field name=\"Lrygm\"><![CDATA[]]></field>//(14)容易患感冒\n" +
                    "            <field name=\"Lbslbt\"><![CDATA[]]></field>//(15)没有感冒鼻塞、流鼻涕\n" +
                    "            <field name=\"Lknndh\"><![CDATA[]]></field>//(16)口粘口腻或睡眠打鼾\n" +
                    "            <field name=\"Lgm\"><![CDATA[]]></field>//(17)容易过敏\n" +
                    "            <field name=\"Lxmz\"><![CDATA[]]></field>//(18)皮肤容易起荨麻疹\n" +
                    "            <field name=\"Lpfqzcx\"><![CDATA[]]></field>//(19)皮肤在不知不觉中会出现青紫瘀斑、皮下出血\n" +
                    "            <field name=\"Lpfhhfy\"><![CDATA[]]></field>//(20)皮肤一抓就红，并出现抓痕\n" +
                    "            <field name=\"Lpfkcg\"><![CDATA[]]></field>//(21)皮肤或口唇干\n" +
                    "            <field name=\"Lztmmtt\"><![CDATA[]]></field>//(22)肢体麻木或固定部位疼痛\n" +
                    "            <field name=\"Lynyl\"><![CDATA[]]></field>//(23)面部或鼻部有油腻感或者油亮发光\n" +
                    "            <field name=\"Lmsmk\"><![CDATA[]]></field>//(24)面色或目眶晦黯，或出现褐色斑块/斑点\n" +
                    "            <field name=\"Lpfszcj\"><![CDATA[]]></field>//(25)皮肤湿疹、疮疖\n" +
                    "            <field name=\"Lkgyzhs\"><![CDATA[]]></field>//(26)口干咽燥、总想喝水\n" +
                    "            <field name=\"Lkkkc\"><![CDATA[]]></field>//(27)口苦或嘴里有异味\n" +
                    "            <field name=\"Lfbfd\"><![CDATA[]]></field>//(28)腹部肥大\n" +
                    "            <field name=\"Lbxhls\"><![CDATA[]]></field>//(29)吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西\n" +
                    "            <field name=\"Ldbnz\"><![CDATA[]]></field>//(30)大便黏滞\n" +
                    "            <field name=\"Ldbgz\"><![CDATA[]]></field>//(31)大便干燥\n" +
                    "            <field name=\"Lsthn\"><![CDATA[]]></field>//(32)舌苔厚腻\n" +
                    "            <field name=\"Lsxjmyz\"><![CDATA[]]></field>//(33)舌下静脉瘀紫或增粗\n" +
                    "            <field name=\"Lphdf\"><![CDATA[" + lnrzytz.getAbnormityId1() + "]]></field>//平和质得分\n" +
                    "            <field name=\"Lphbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9200") + "]]></field>//平和质辨识\n" +
                    "            <field name=\"Lqxdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气虚质得分\n" +
                    "            <field name=\"Lqxbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9201") + "]]></field>//气虚质辨识\n" +
                    "            <field name=\"Lyangdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阳虚质得分\n" +
                    "            <field name=\"Lyangbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9202") + "]]></field>//阳虚质辨识\n" +
                    "            <field name=\"Lyindf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阴虚质得分\n" +
                    "            <field name=\"Lyinbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9203") + "]]></field>//阴虚质辨识\n" +
                    "            <field name=\"Ltsdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//痰湿质得分\n" +
                    "            <field name=\"Ltsbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9204") + "]]></field>//痰湿质辨识\n" +
                    "            <field name=\"Lsrdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//湿热质得分\n" +
                    "            <field name=\"Lsrbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9205") + "]]></field>//湿热质辨识\n" +
                    "            <field name=\"Lxydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//血瘀质得分\n" +
                    "            <field name=\"Lxybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9206") + "]]></field>//血瘀质辨识\n" +
                    "            <field name=\"Lqydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气郁质得分\n" +
                    "            <field name=\"Lqybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9207") + "]]></field>//气郁质辨识\n" +
                    "            <field name=\"Ltbdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//特禀质得分\n" +
                    "            <field name=\"Ltbbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9208") + "]]></field>/特禀质辨识\n" +
                    "            <field name=\"happentime\"><![CDATA[" + util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date()) + "]]></field>//填表日期\n" +
                    "            <field name=\"ysqm\"><![CDATA[" + peReportDepartmentDetailMapper.getDoctorName(id) + "]]></field>//医生签名\n" +
                    "        </subrow>\n" +
                    "            </row>\n" +
                    "</XMLTOPERSONS>";
            return xml;
        }else {
            Lnrzytz1 lnrzytz = getInfo2(id);
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "        <XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                    "            <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                    "                <field name=\"DSfzh\">" + peReportDepartmentDetailMapper.getPersionCardTime(id).getPerson_no() + "</field>\n" +
                    "        <subrow name=\"T_LNR_ZYYTZGL\">//老年人中医体质\n" +
                    "            <field name=\"Ljl\"><![CDATA[" + list.get(0).getAnswer() + "]]></field>//(1)精力\n" +
                    "            <field name=\"Ltl\"><![CDATA[" + list.get(1).getAnswer() + "]]></field>//(2)体力\n" +
                    "            <field name=\"Lhx\"><![CDATA[" + list.get(2).getAnswer() + "]]></field>//(3)呼吸短促\n" +
                    "            <field name=\"Lsh\"><![CDATA[" + list.get(3).getAnswer() + "]]></field>//(4)说话\n" +
                    "            <field name=\"Lxq\"><![CDATA[" + list.get(4).getAnswer() + "]]></field>//(5)心情\n" +
                    "            <field name=\"Ljzjl\"><![CDATA[" + list.get(5).getAnswer() + "]]></field>//(6)精神紧张、焦虑不安\n" +
                    "            <field name=\"Lshztgb\"><![CDATA[" + list.get(6).getAnswer() + "]]></field>//(7)生活状态改变\n" +
                    "            <field name=\"Lhpjx\"><![CDATA[" + list.get(7).getAnswer() + "]]></field>//(8)害怕或惊吓\n" +
                    "            <field name=\"Lstcz\"><![CDATA[" + list.get(8).getAnswer() + "]]></field>//(9)身体超重\n" +
                    "            <field name=\"Lyjgs\"><![CDATA[" + list.get(9).getAnswer() + "]]></field>//(10)眼睛干涩\n" +
                    "            <field name=\"Lsjfl\"><![CDATA[" + list.get(10).getAnswer() + "]]></field>//(11)手脚发凉\n" +
                    "            <field name=\"Lwwbyx\"><![CDATA[" + list.get(11).getAnswer() + "]]></field>//(12)胃脘部、背部或腰膝部怕冷\n" +
                    "            <field name=\"Lsblhl\"><![CDATA[" + list.get(12).getAnswer() + "]]></field>//(13)受不了寒冷\n" +
                    "            <field name=\"Lrygm\"><![CDATA[" + list.get(13).getAnswer() + "]]></field>//(14)容易患感冒\n" +
                    "            <field name=\"Lbslbt\"><![CDATA[" + list.get(14).getAnswer() + "]]></field>//(15)没有感冒鼻塞、流鼻涕\n" +
                    "            <field name=\"Lknndh\"><![CDATA[" + list.get(15).getAnswer() + "]]></field>//(16)口粘口腻或睡眠打鼾\n" +
                    "            <field name=\"Lgm\"><![CDATA[" + list.get(16).getAnswer() + "]]></field>//(17)容易过敏\n" +
                    "            <field name=\"Lxmz\"><![CDATA[" + list.get(17).getAnswer() + "]]></field>//(18)皮肤容易起荨麻疹\n" +
                    "            <field name=\"Lpfqzcx\"><![CDATA[" + list.get(18).getAnswer() + "]]></field>//(19)皮肤在不知不觉中会出现青紫瘀斑、皮下出血\n" +
                    "            <field name=\"Lpfhhfy\"><![CDATA[" + list.get(19).getAnswer() + "]]></field>//(20)皮肤一抓就红，并出现抓痕\n" +
                    "            <field name=\"Lpfkcg\"><![CDATA[" + list.get(20).getAnswer() + "]]></field>//(21)皮肤或口唇干\n" +
                    "            <field name=\"Lztmmtt\"><![CDATA[" + list.get(21).getAnswer() + "]]></field>//(22)肢体麻木或固定部位疼痛\n" +
                    "            <field name=\"Lynyl\"><![CDATA[" + list.get(22).getAnswer() + "]]></field>//(23)面部或鼻部有油腻感或者油亮发光\n" +
                    "            <field name=\"Lmsmk\"><![CDATA[" + list.get(23).getAnswer() + "]]></field>//(24)面色或目眶晦黯，或出现褐色斑块/斑点\n" +
                    "            <field name=\"Lpfszcj\"><![CDATA[" + list.get(24).getAnswer() + "]]></field>//(25)皮肤湿疹、疮疖\n" +
                    "            <field name=\"Lkgyzhs\"><![CDATA[" + list.get(25).getAnswer() + "]]></field>//(26)口干咽燥、总想喝水\n" +
                    "            <field name=\"Lkkkc\"><![CDATA[" + list.get(26).getAnswer() + "]]></field>//(27)口苦或嘴里有异味\n" +
                    "            <field name=\"Lfbfd\"><![CDATA[" + list.get(27).getAnswer() + "]]></field>//(28)腹部肥大\n" +
                    "            <field name=\"Lbxhls\"><![CDATA[" + list.get(28).getAnswer() + "]]></field>//(29)吃(喝)凉的东西会感到不舒服或者怕吃(喝)凉的东西\n" +
                    "            <field name=\"Ldbnz\"><![CDATA[" + list.get(29).getAnswer() + "]]></field>//(30)大便黏滞\n" +
                    "            <field name=\"Ldbgz\"><![CDATA[" + list.get(30).getAnswer() + "]]></field>//(31)大便干燥\n" +
                    "            <field name=\"Lsthn\"><![CDATA[" + list.get(31).getAnswer() + "]]></field>//(32)舌苔厚腻\n" +
                    "            <field name=\"Lsxjmyz\"><![CDATA[" + list.get(32).getAnswer() + "]]></field>//(33)舌下静脉瘀紫或增粗\n" +
                    "            <field name=\"Lphdf\"><![CDATA[" + lnrzytz.getAbnormityId1() + "]]></field>//平和质得分\n" +
                    "            <field name=\"Lphbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9200") + "]]></field>//平和质辨识\n" +
                    "            <field name=\"Lqxdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气虚质得分\n" +
                    "            <field name=\"Lqxbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9201") + "]]></field>//气虚质辨识\n" +
                    "            <field name=\"Lyangdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阳虚质得分\n" +
                    "            <field name=\"Lyangbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9202") + "]]></field>//阳虚质辨识\n" +
                    "            <field name=\"Lyindf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//阴虚质得分\n" +
                    "            <field name=\"Lyinbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9203") + "]]></field>//阴虚质辨识\n" +
                    "            <field name=\"Ltsdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//痰湿质得分\n" +
                    "            <field name=\"Ltsbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9204") + "]]></field>//痰湿质辨识\n" +
                    "            <field name=\"Lsrdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//湿热质得分\n" +
                    "            <field name=\"Lsrbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9205") + "]]></field>//湿热质辨识\n" +
                    "            <field name=\"Lxydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//血瘀质得分\n" +
                    "            <field name=\"Lxybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9206") + "]]></field>//血瘀质辨识\n" +
                    "            <field name=\"Lqydf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//气郁质得分\n" +
                    "            <field name=\"Lqybs\"><![CDATA[" + util.xmlOne(list1, "LNCT9207") + "]]></field>//气郁质辨识\n" +
                    "            <field name=\"Ltbdf\"><![CDATA[" + lnrzytz.getAbnormityId2() + "]]></field>//特禀质得分\n" +
                    "            <field name=\"Ltbbs\"><![CDATA[" + util.xmlOne(list1, "LNCT9208") + "]]></field>/特禀质辨识\n" +
                    "            <field name=\"happentime\"><![CDATA[" + util.Datenyr(peReportDepartmentDetailMapper.getPersionCardTime(id).getPe_date()) + "]]></field>//填表日期\n" +
                    "            <field name=\"ysqm\"><![CDATA[" + peReportDepartmentDetailMapper.getDoctorName(id) + "]]></field>//医生签名\n" +
                    "        </subrow>\n" +
                    "            </row>\n" +
                    "</XMLTOPERSONS>";
            WebService factory = new WebService();
            WebServicePortType webServiceHttpPort = factory.getWebServiceHttpPort();
            String hello = webServiceHttpPort.dataCenterWebservice("3B86EDC086794717A76AAD14ED0A0AA6", "61fe6b60e8174071a341b2f2602d86e4", xml);
            return hello;
        }
    }
}
