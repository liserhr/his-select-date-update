package com.dateupdate.com.springmvc.service.impl;

import com.dateupdate.com.springmvc.mapper.PeReportDepartmentDetailMapper;
import com.dateupdate.com.springmvc.model.CardTimeDocutor;
import com.dateupdate.com.springmvc.model.ListOne;
import com.dateupdate.com.springmvc.service.api.JktjService;
import com.dateupdate.com.springmvc.util.Util;
import com.dateupdate.com.webService.WebService;
import com.dateupdate.com.webService.WebServicePortType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JktjServiceImpl implements JktjService {


    @Autowired
    private PeReportDepartmentDetailMapper peReportDepartmentDetailMapper;

    Util util = new Util();



    @Override
    public List<ListOne> getById(String id) {
        List<ListOne> a =  peReportDepartmentDetailMapper.selectForListOne(id);
        return a;
    }


    public String getDocutorName(String id){
        return peReportDepartmentDetailMapper.getDoctorName(id);
    }



    @Override
    public CardTimeDocutor getTest(String id) {
       CardTimeDocutor a = peReportDepartmentDetailMapper.getPersionCardTime(id);
       if (a.getPe_date()==null || a.getOperator_id() == null || a.getPerson_no() == null){
           return  null;
       }
       return a;
    }

    @Override
    public String getXml(String id) {
        // 首先将数据库里面的数据取出来
        List<ListOne>  jktjList = peReportDepartmentDetailMapper.selectForListOne(id);

        if (jktjList.size()==0){
            return "抱歉，你查询的id没有相关信息，不能生成xml";
        }else {
            // 然后我们进行拼接xml
            String jktjxml ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "<XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                    "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                    "        <field name=\"DSfzh\">"+getTest(id).getPerson_no()+"</field>\n" +
                    "       <subrow name=\"T_JK_JKTJ\">  //健康体检\n" +
                    util.MoreOrOne(jktjList,id,getTest(id).getPe_date())+
                    "\t<field name=\"GZhzh\"><![CDATA["+util.zz(util.number(util.xmlOne(jktjList,"LNCT1000")))+"]]></field>  //症状 1.无症状;2.头痛;3.头晕;4.心悸;5.胸闷;6.胸痛;7.慢性咳嗽;8.咳痰;9.呼吸困难;10.多饮;11.多尿;12.体重下降;13.乏力;14.关节肿痛;15.视力模糊;16.手脚麻木;17.尿急;18.尿痛;19.便秘;20.腹泻;21.恶心呕吐;22.眼花;23.耳鸣;24.乳房胀痛;99.其他;\n" +
                    "\t<field name=\"GTw\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1900") + "]]></field>  //体温\n" +
                    "\t<field name=\"GHx\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1902") + "]]></field>  //呼吸频率\n" +
                    "\t<field name=\"GMb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1901") + "]]></field>  //脉率\n" +
                    "\t<field name=\"GXyyc1\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1905") + "]]></field>  //右侧收缩压\n" +
                    "\t<field name=\"GXyyc2\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1906") + "]]></field>  //右侧舒张压\n" +
                    "\t<field name=\"GXyzc1\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1903") + "]]></field>  //左侧收缩压\n" +
                    "\t<field name=\"GXyzc2\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1904") + "]]></field>  //左侧舒张压\n" +
                    "\t<field name=\"GSg\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1907") + "]]></field>  //身高\n" +
                    "\t<field name=\"GYw\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1909") + "]]></field>  //腰围\n" +
                    "\t<field name=\"GTzh\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1908") + "]]></field>  //体重\n" +
                    "\t<field name=\"GTzhzh\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1910") + "]]></field>  //体重指数(BMI)\n" +
                    "\t<field name=\"GLnrrz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1913"))+"]]></field>  //1.阴性；2.阳性;\n" +
                    "\t<field name=\"GLnrqg\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1914"))+"]]></field>  //1.阴性；2.阳性;\n" +
                    "\t<field name=\"GLnrrzfen\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1913B") + "]]></field>  //老年人认知能力分数\n" +
                    "\t<field name=\"GLnrqgfen\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1914B") + "]]></field>   //老年人情感能力分数\n" +
                    "\t<field name=\"GZysl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1953") + "]]></field>  //左眼视力\n" +
                    "\t<field name=\"GYysl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1954") + "]]></field>  //右眼视力\n" +
                    "\t<field name=\"GZyjz\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1955") + "]]></field>  //左眼矫正视力\n" +
                    "\t<field name=\"GYyjz\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1956") + "]]></field>  //右眼矫正视力\n" +
                    "\t<field name=\"GTl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1957")) + "]]></field>  // 听 力 1.听见;2.听不清或无法听见（耳鼻喉科专科就诊）;\n" +
                    "\t<field name=\"GYdgn\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1958")) + "]]></field>  // 运动功能 1.可顺利完成;2.无法独立完成其中任何一个动作(上级医院就诊);\n" +
                    "\t<field name=\"GPfgm\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1960")) + "]]></field>  // 皮 肤 1.正常;2.潮红;3.苍白;4.发绀;5.黄染;6.色素沉着;99.其他;\n" +
                    "\t<field name=\"GLbj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1962")) + "]]></field>  // 淋巴结 1.未触及;2.锁骨上;3.腋窝;4.其他;\n" +
                    "\t<field name=\"GLbjqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1962B") + "]]></field>  ///淋巴结其他\n" +
                    "\t<field name=\"GTzx\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1963")) + "]]></field>  //  桶状胸： 1.是;2.否;\n" +
                    "\t<field name=\"GHxy\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1964")) + "]]></field>  // 呼吸音： 1.正常;2.异常;\n" +
                    "\t<field name=\"GHxyyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1964B") + "]]></field>  //呼吸音异常  和字段GHxy有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GLy\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1965")) + "]]></field>  // 罗 音： 1.无;2.干罗音;3.湿罗音;4.其他;\n" +
                    "\t<field name=\"GLyyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1965B") + "]]></field>  //罗音其他\n" +
                    "\t<field name=\"GXinlv\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1966") + "]]></field>  //心率\n" +
                    "\t<field name=\"GXinlvci\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1967")) + "]]></field>  // 心律： 1.齐;2.不齐;3.绝对不齐;\n" +
                    "\t<field name=\"GZayin\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1968")) + "]]></field>  // 杂音： 1.无;2.有;\n" +
                    "\t<field name=\"GZayinyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1968B") + "]]></field>  //有杂音  和字段GZayin有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GYato\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1969")) + "]]></field>  // 压痛： 1.无;2.有;\n" +
                    "\t<field name=\"GYatoyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1969B") + "]]></field>  //有压痛  和字段GYato有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GBk\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1970")) + "]]></field>  // 包块： 1.无;2.有;\n" +
                    "\t<field name=\"GBkyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1970B") + "]]></field>  // 有包块  和字段GBk有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GGanda\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1971")) + "]]></field>  // 肝大： 1.无;2.有;\n" +
                    "\t<field name=\"GGandayo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1971B") + "]]></field>  //有肝大  和字段GGanda有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GPida\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1972")) + "]]></field>  // 脾大： 1.无;2.有;\n" +
                    "\t<field name=\"GPidayo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1972B") + "]]></field>  //有脾大： 和字段GPida有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GZhuoyin\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1973")) + "]]></field>  // 移动性浊音： 1.无;2.有;\n" +
                    "\t<field name=\"GZhuoyinyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1973B") + "]]></field>  //有移动性浊音：  和字段GZhuoyin有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GXzsz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1974") )+ "]]></field>  //下肢水肿 1.无;2.左侧;3.右侧;4.双侧不对称;5.双侧对称;\n" +
                    "\t<field name=\"GGmzhzh\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1976")) + "]]></field>  // 肛门指诊 1.未见异常;2.触痛;3.包块;4.前列腺异常;99.其他;\n" +
                    "\t<field name=\"GGmzhzhyi\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1976B") + "]]></field>  //其他肛门指诊  和字段GGmzhzh有关系，当为99时，使用此字段\n" +
                    "\t<field name=\"GQlx\"><![CDATA[]]></field>      // 暂时不对应\n" +
                    "\t<field name=\"GCtqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1983") + "]]></field>  //其他查体 \n" +
                    "\t<field name=\"wbc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9001") + "]]></field>  //血常规-白细胞\n" +
                    "\t<field name=\"hb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9013") + "]]></field>  //血常规-血红蛋白\n" +
                    "\t<field name=\"plt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9018") + "]]></field>  //血常规-血小板\n" +
                    "\t<field name=\"GXcgqt\"><![CDATA[红细胞："+ util.xmlOne(jktjList, "LNCT9012") +",中性细胞粒："+ util.xmlOne(jktjList, "LNCT9007") + ",淋巴细胞："+ util.xmlOne(jktjList, "LNCT9008") +"]]></field>  //血常规-其他\n" +
                    "\t<field name=\"GNdb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9107") + "]]></field>  //尿常规-尿蛋白\n" +
                    "\t<field name=\"GNt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9103") + "]]></field>  //尿常规-尿糖\n" +
                    "\t<field name=\"GNtt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9110")+"]]></field>  //尿常规-尿酮体\n" +
                    "\t<field name=\"GNqx\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9106") + "]]></field>  //尿常规-尿潜血\n" +
                    "\t<field name=\"GNcgqt\"><![CDATA[白细胞："+ util.xmlOne(jktjList, "LNCT9111") +"]]></field>  //尿常规-其他\n" +
                    "\t<field name=\"GDbqx\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9130") )+ "]]></field>  // 大便潜血 1.阴性;2.阳性;\n" +
                    "\t<field name=\"alt\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2001") + "]]></field>  //肝功能-血清谷丙转氨酶\n" +
                    "\t<field name=\"ast\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2002") + "]]></field>  //肝功能-血清谷草转氨酶\n" +
                    "\t<field name=\"alb\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2012") + "]]></field>  //肝功能-白蛋白\n" +
                    "\t<field name=\"tbil\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2008") + "]]></field>  //肝功能-总胆红素\n" +
                    "\t<field name=\"dbil\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2009")+ "]]></field>  //肝功能-结合胆红素\n" +
                    "\t<field name=\"scr\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2016") + "]]></field>  //肾功能-血清肌酐\n" +
                    "\t<field name=\"bun\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2015") + "]]></field>  //肾功能-血尿素氮\n" +
                    "\t<field name=\"cho\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2021") + "]]></field>  //血脂-总胆固醇\n" +
                    "\t<field name=\"tg\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2022") + "]]></field>  //血脂-甘油三酯\n" +
                    "\t<field name=\"ldlc\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2024") + "]]></field>  //血脂-血清低密度脂蛋白胆固醇\n" +
                    "\t<field name=\"hdlc\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2023") + "]]></field>  //血脂-血清高密度脂蛋白胆固醇\n" +
                    "\t<field name=\"GKfxt\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2025") + "]]></field>  //空腹血糖\n" +
                    "\t<field name=\"hbsag\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2134") + "]]></field>  // 乙型肝炎表面抗原 1.阴性;2.阳性;\n" +
                    "\t<field name=\"GYand\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1959")) + "]]></field>  // 眼 底 1.正常;2.异常;\n" +
                    "\t<field name=\"GYandyi\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1959B") + "]]></field>  //眼底异常  和字段GYand有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GXindt\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT8000")) + "]]></field>  // 心电图 1.正常;2.异常; \n" +
                    "\t<field name=\"GXindtyi\"><![CDATA[" + util.xmlOne(jktjList, "LNCT8000B") + "]]></field>  //心电图异常填写  和字段GXindt有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GXiongp\"><![CDATA[]]></field>  // 胸部X线片 1.正常;2.异常;\n" +
                    "\t<field name=\"GXiongpyc\"><![CDATA[]]></field>  //胸部X线片异常  和字段GXiongp有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GBchao\"><![CDATA[" + util.Bchao(util.xmlOne(jktjList, "LNCT8100")) + "]]></field>  // B 超 1.正常;2.异常;\n" +
                    "\t<field name=\"GBchaoyi\"><![CDATA[" + util.BchaoYC(util.xmlOne(jktjList, "LNCT8100" )) + "]]></field>  //B 超异常  和字段GBchao有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GFuzhuqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT8300") + "]]></field>  //辅助检查其他\n" +
                    "\t<field name=\"GJljjy\"><![CDATA[]]></field>  \t//暂时不对应\n" +
                    "\t<field name=\"happentime\"><![CDATA["+util.Datenyr(getTest(id).getPe_date())+"]]></field>  //体检日期\n" +
                    "\t<field name=\"field1\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"field2\"><![CDATA["+getDocutorName(id)+"]]></field>  //责任医生\n" +
                    "\t<field name=\"field3\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"field4\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"GTunwei\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"GYtwbz\"><![CDATA[]]></field>   //暂时不对应\n" +
                    "\t<field name=\"GDlpl\"><![CDATA["+util.xmlOne(jktjList,"LNCT1915")+"]]></field>  // 锻炼频率 1.每天;2.每周一次以上;3.偶尔;4.不锻炼;\n" +
                    "\t<field name=\"GMcdlsj\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1916") + "]]></field>  //每次锻炼时间\n" +
                    "\t<field name=\"GJcdlsj\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1917") + "]]></field>  //坚持锻炼时间\n" +
                    "\t<field name=\"GDlfs\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1918") + "]]></field>  //锻炼方式\n" +
                    "\t<field name=\"GYsxg\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1919")) + "]]></field>  // 饮食习惯 1.荤素均衡;2.荤食为主;3.素食为主;4.嗜盐;5.嗜油;6.嗜糖;\n" +
                    "\t<field name=\"GXyzk\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1920")) + "]]></field>  // 吸烟状况  1.从不吸烟;2.已戒烟;3.吸烟;\n" +
                    "\t<field name=\"GRxyl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1921") + "]]></field>  //日吸烟量\n" +
                    "\t<field name=\"GKsxynl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1922") + "]]></field>  //开始吸烟年龄\n" +
                    "\t<field name=\"GJynl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1923") + "]]></field>  //戒烟年龄\n" +
                    "\t<field name=\"GYjpl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1924")) + "]]></field>  // 饮酒频率 1.从不;2.偶尔;3.经常;4.每天;\n" +
                    "\t<field name=\"GRyjl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1925") + "]]></field>  //日饮酒量\n" +
                    "\t<field name=\"GSfjj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1926")) + "]]></field>  //是否戒酒   1.未戒酒;2.已戒酒;\n" +
                    "\t<field name=\"GJjnl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1927") + "]]></field>  //戒酒年龄\n" +
                    "\t<field name=\"GKsyjnl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1928") + "]]></field>  //开始饮酒年龄\n" +
                    "\t<field name=\"GYnnsfyj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1929")) + "]]></field>  // 近一年内是否曾醉酒 1.是;2.否;\n" +
                    "\t<field name=\"GYjzl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1930") )+ "]]></field>  // 饮酒种类 1.白酒;2.啤酒;3.红酒;4.黄酒;99.其他;\n" +
                    "\t<field name=\"GYjzlqt\"><![CDATA[]]></field>  //其他饮酒种类   和字段GYjzl有关联，当为99时，使用此字段\n" +
                    "\t<field name=\"GYwzybl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1931")) + "]]></field>  // 职业病危害因素接触史 1.无;2.有;\n" +
                    "\t<field name=\"GJtzy\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1932") + "]]></field>  //工种  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"GCysj\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1933") + "]]></field>  //从业时间  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"GHxp\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1940") + "]]></field>  //化学物质  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"GHxpfhcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1941")) + "]]></field>  // 职业病危害因素接触史-化学物质-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"GHxpfhcsjt\"><![CDATA[]]></field>  //化学物质措施  和字段GHxpfhcs有关联，当为2时，使用此字段\n" +
                    "\t<field name=\"GDuwu\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"GDwfhcs\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"GDwfhcsqt\"><![CDATA[]]></field>  //暂时不对应\n" +
                    "\t<field name=\"GShexian\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1936") + "]]></field>  //放射物质  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"GSxfhcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1937")) + "]]></field>  // 职业病危害因素接触史-放射物质-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"GSxfhcsqt\"><![CDATA[]]></field>  //放射物质措施 和字段GSxfhcs有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GKouchun\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1950")) + "]]></field>  // 口唇 1.红润;2.苍白;3.发绀;4.皲裂;5.疱疹;6.其他;\n" +
                    "\t<field name=\"GChilei\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1951")) + "]]></field>  // 齿列 1.正常;2.缺齿;3.龋齿;4.义齿(假牙);5.其他;  \n" +
                    "\t<field name=\"GYanbu\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1952")) + "]]></field>  // 咽部 1.无充血;2.充血;3.淋巴滤泡增生;4.其他;\n" +
                    "\t<field name=\"GPfqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1960B") + "]]></field>  //皮 肤其他\n" +
                    "\t<field name=\"GGongmo\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1961")) + "]]></field>  // 巩 膜 1.正常;2.黄染;3.充血;99.其他;\n" +
                    "\t<field name=\"GGmqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1961B") + "]]></field>   // 巩 膜其他\n" +
                    "\t<field name=\"GZbdmmd\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1975")) + "]]></field>  // 足背动脉搏动 1.未触及;2.触及双侧对称;3.触及左侧弱或消失;4.触及右侧弱或消失;\n" +
                    "\t<field name=\"GRuxian\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1977")) + "]]></field>  // 乳 腺 1.未见异常;2.乳房切除;3.异常泌乳;4.乳腺包块;99.其他;\n" +
                    "\t<field name=\"GRuxianqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1977B") + "]]></field>  //其他乳腺  和字段GRuxian有关系，当为99时，使用此字段\n" +
                    "\t<field name=\"GWaiyin\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1978")) + "]]></field>  // 外阴 1.未见异常;2.异常;\n" +
                    "\t<field name=\"GWaiyinyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1978B") + "]]></field>  //外阴异常  和字段GWaiyin有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GYindao\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1979")) + "]]></field>  // 阴道 1.未见异常;2.异常;\n" +
                    "\t<field name=\"GYindaoyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1979B") + "]]></field>  //阴道异常  和字段GYindao有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GGongjing\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1980")) + "]]></field>  // 宫颈 1.未见异常;2.异常;\n" +
                    "\t<field name=\"GGongjingyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1980B") + "]]></field>  //宫颈异常  和字段GGongjing有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GGongti\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1981")) + "]]></field>  // 宫体 1.未见异常;2.异常;\n" +
                    "\t<field name=\"GGongtiyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1981B") + "]]></field>  //宫体异常\n" +
                    "\t<field name=\"GFujian\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1982") )+ "]]></field>  // 附件 1.未见异常;2.异常;\n" +
                    "\t<field name=\"GFujianyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1982B") + "]]></field>  //附件异常\n" +
                    "\t<field name=\"GSgnxjnd\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2137") + "]]></field>  //肾功能-血钾浓度\n" +
                    "\t<field name=\"GSgnxnnd\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2138") + "]]></field>  //肾功能-血钠浓度\n" +
                    "\t<field name=\"GThxhdb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9121") + "]]></field>  //糖化血红蛋白\n" +
                    "\t<field name=\"GGjtp\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT8400")) + "]]></field>  // 宫颈涂片 1.正常;2.异常;\n" +
                    "\t<field name=\"GGjtpyc\"><![CDATA[]]></field>  //宫颈涂片异常  和字段GGjtp有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GPhz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9200")) + "]]></field>  // 平和质 1.是;2.基本是;\n" +
                    "\t<field name=\"GQxz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9201")) + "]]></field>  // 气虚质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GYangxz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9202")) + "]]></field>  // 阳虚质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GYinxz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9203")) + "]]></field>  // 阴虚质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GTsz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9204")) + "]]></field>  // 痰湿质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GSrz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9205")) + "]]></field>  // 湿热质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GXyz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9206"))+ "]]></field>  // 血瘀质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GQyz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9207")) + "]]></field>  // 气郁质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GTbz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9208")) + "]]></field>  // 特秉质 1.是;2.倾向是;\n" +
                    "\t<field name=\"GNxgjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9300")) + "]]></field>  // 脑血管疾病 1.未发现;2.缺血性卒中;3.脑出血;4.蛛网膜下腔出血;5.短暂性脑缺血发作;99.其他;\n" +
                    "\t<field name=\"GNxgjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9300B")+ "]]></field>   // 脑血管疾病 其他\n" +
                    "\t<field name=\"GSzjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9301")) + "]]></field>  // 肾脏疾病 1.未发现;2.糖尿病肾病;3.肾功能衰竭;4.急性肾炎;5.慢性肾炎;99.其他;\n" +
                    "\t<field name=\"GSzjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9301B")+"]]></field>  // 肾脏疾病其他\n" +
                    "\t<field name=\"GXzjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9302")) + "]]></field>  // 心脏疾病 1.未发现;2.心肌梗死;3.心绞痛;4.冠状动脉血运重建;5.充血性心力衰竭;6.心前区疼痛;99.其他;\n" +
                    "\t<field name=\"GXzjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9302B")+"]]></field>  // 心脏疾病其他\n" +
                    "\t<field name=\"GXgjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9303")) + "]]></field>  // 血管疾病 1.未发现;2.夹层动脉瘤;3.动脉闭塞性疾病;99.其他;\n" +
                    "\t<field name=\"GXgjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9303B")+"]]></field>  // 血管疾病其他\n" +
                    "\t<field name=\"GYbjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9304")) + "]]></field>  //  眼部疾病1.未发现;2.视网膜出血或渗出;3.视乳头水肿;4.白内障;99.其他;\n" +
                    "\t<field name=\"GYbjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9304B") + "]]></field>  //  眼部疾病其他\n" +
                    "\t<field name=\"GSjxtjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9305")) + "]]></field>  // 神经系统疾病 1.未发现;2.有;\n" +
                    "\t<field name=\"GSjxtjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9305B")+"]]></field>  //神经系统疾病有时的填写\n" +
                    "\t<field name=\"GQtxtjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9306")) + "]]></field>  // 其他系统疾病 1.未发现;2.有;\n" +
                    "\t<field name=\"GQtxtjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9306B")+"]]></field>  //其他系统疾病有时填写\n" +
                    "\t<field name=\"GJkpj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9460")) + "]]></field>  // 健康评价 1.体检无异常;2.有异常;\n" +
                    "\t<field name=\"GJkpjyc1\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9461") + "]]></field>  //健康评价异常1  和字段GJkpj有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GJkpjyc2\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9462") + "]]></field>  //健康评价异常2  和字段GJkpj有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GJkpjyc3\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9463") + "]]></field>  //健康评价异常3  和字段GJkpj有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GJkpjyc4\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9464") + "]]></field>  //健康评价异常4  和字段GJkpj有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"GJkzd\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9465")) + "]]></field>  // 健康指导 1.定期随访;2.纳入慢性病管理;3.建议复查;4.建议转诊;\n" +
                    "\t<field name=\"GWxyskz\"><![CDATA[" + util.wxys(util.number(util.xmlOne(jktjList, "LNCT9466")))+"]]></field>  // 危险因素控制 1.戒烟;2.健康饮酒;3.饮食;4.锻炼;97.减体重;98.建议疫苗接种;99.其他;\n" +
                    "\t<field name=\"GWxystz\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9467") + "]]></field>  //危险因素控制  目标填写\n" +
                    "\t<field name=\"GWsysym\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9468") + "]]></field>  //危险因素控制建议疫苗接种 填写\n" +
                    "\t<field name=\"GWxysqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9469") + "]]></field>  //危险因素控制其他  填写\n" +
                    "\t<field name=\"field5\"><![CDATA[]]></field>  //暂不对应\n" +
                    "\t<field name=\"GZzqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1000B") +"]]></field>  //其他症状    和字段GZhzh有联系，当为99时，使用此字段\n" +
                    "\t<field name=\"GXyyc\"><![CDATA[]]></field>  //不对应\n" +
                    "\t<field name=\"GXyzc\"><![CDATA[]]></field>  //不对应\n" +
                    "\t<field name=\"GQtzhzh\"><![CDATA[]]></field>  //不对应\n" +
                    "\t<field name=\"qdqxz\"><![CDATA[]]></field>  //不对应\n" +
                    "\t<field name=\"info\"><![CDATA[]]></field>   //不对应\n" +
                    "\t<field name=\"kchqt\"><![CDATA[]]></field>  //口唇其他  和字段GKouchun有关系，当为6时，使用此字段\n" +
                    "\t<field name=\"chlqt\"><![CDATA[]]></field>  //齿列其他  \n" +
                    "\t<field name=\"ybqt\"><![CDATA[]]></field>  //咽部其他  和字段GYanbu有关系，当为4时，使用此字段\n" +
                    "\t<field name=\"ydgnqt\"><![CDATA[]]></field>  //不对应\n" +
                    "\t<field name=\"wzd\"><![CDATA[]]></field>   //不对应\n" +
                    "\t<field name=\"GChxt\"><![CDATA[]]></field>  //餐后2H血糖\n" +
                    "\t<field name=\"lnrzkpg\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1911")) + "]]></field>  // 老年人健康状态自我评估 1.满意;2.基本满意;3.说不清楚;4.不太满意;5.不满意;\n" +
                    "\t<field name=\"lnrzlpg\"><![CDATA[" + util.number1(util.number(util.xmlOne(jktjList, "LNCT1912"))) + "]]></field>  // 老年人生活自理能力自我评估 1.可自理(0～3分);2.轻度依赖(4～8分);3.中度依赖(9～18分);4.不能自理(≥19分);\n" +
                    "\t<field name=\"fenchen\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1934") + "]]></field>  //粉尘  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"wuliyinsu\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1938") + "]]></field>  //物理因素 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"blqita\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1942") + "]]></field>  //职业病危害因素接触史 其他  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"fchcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1935")) + "]]></field>  // 职业病危害因素接触史-粉尘-防护措施  1.无;2.有;  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"wlcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1939")) + "]]></field>  // 职业病危害因素接触史-物理因素-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"blqtcs\"><![CDATA[" + util.number(util.xmlOne(jktjList,"LNCT1943")) + "]]></field>  // 职业病危害因素接触史-其他-防护措施 1.无;2.有;  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                    "\t<field name=\"fchY\"><![CDATA[]]></field>  //粉尘措施  和字段fchcs有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"wlY\"><![CDATA[]]></field>  //物理因素措施  和字段wlcs有关系，当为2时，使用此字段\n" +
                    "\t<field name=\"qtY\"><![CDATA[]]></field>  //职业病危害因素接触史-其他措施  和字段blqtcs有关联，当为2时，使用此字段\n" +
                    "\t<field name=\"tnbfxjf\"><![CDATA[]]></field>  //不对应\n" +
                    "\t<field name=\"zcyy\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1904B") + "]]></field>  //左侧原因\n" +
                    "\t<field name=\"ycyy\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1906B") + "]]></field>  //右侧原因\n" +
                    "\t<field name=\"nwlbdb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9112") + "]]></field>  //尿微量白蛋白 \n" +
                    "\t<field name=\"DJkbs\"><![CDATA[]]></field>  //不对应\n" +
                    "    <field name=\"GClque\"><![CDATA["+ util.yc(util.xmlOne(jktjList, "LNCT1951C")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951B")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951E") )+"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951D")) +"]]></field>  //缺齿\n" +
                    "    <field name=\"GClqu\"><![CDATA["+ util.yc(util.xmlOne(jktjList, "LNCT1951G")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951F")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951I")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951H") )+"]]></field>  //龋齿\n" +
                    "<field name=\"GClyi\"><![CDATA["+ util.yc(util.xmlOne(jktjList, "LNCT1951K") )+"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951J")) + "@"+util.yc(util.xmlOne(jktjList, "LNCT1951M")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951L")) +"]]></field>  //义齿(假牙)\n" +
                    "<field name=\"Ysqmzz\"><![CDATA["+getDocutorName(id)+"]]></field>  //医师签名-症状\n" +
                    "<field name=\"Ysqm_zz\"><![CDATA["+getDocutorName(id)+"]]></field>  //医师签名-症状\n" +
                    "</subrow>   "+
                    "    </row>\n" +
                    "</XMLTOPERSONS>";
            return jktjxml;
        }
    }

    @Override
    public String sendXml(String id) {
       List<ListOne> jktjList =  peReportDepartmentDetailMapper.selectForListOne(id);
       if (jktjList.size() != 0){

           String xml1 ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                   "<XMLTOPERSONS retrun=\"TRUE\" value=\"0\" username=\"370705B100090012\" prgid=\"370705B10009\" biaoshi=\"2\">\n" +
                   "    <row name=\"T_DA_JKDA_RKXZL\" jkkh=\"\">\n" +
                   "        <field name=\"DSfzh\">"+getTest(id).getPerson_no()+"</field>\n" +
                   "       <subrow name=\"T_JK_JKTJ\">  //健康体检\n" +
                   util.MoreOrOne(jktjList,id,getTest(id).getPe_date())+
                   "\t<field name=\"GZhzh\"><![CDATA["+util.zz(util.number(util.xmlOne(jktjList,"LNCT1000")))+"]]></field>  //症状 1.无症状;2.头痛;3.头晕;4.心悸;5.胸闷;6.胸痛;7.慢性咳嗽;8.咳痰;9.呼吸困难;10.多饮;11.多尿;12.体重下降;13.乏力;14.关节肿痛;15.视力模糊;16.手脚麻木;17.尿急;18.尿痛;19.便秘;20.腹泻;21.恶心呕吐;22.眼花;23.耳鸣;24.乳房胀痛;99.其他;\n" +
                   "\t<field name=\"GTw\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1900") + "]]></field>  //体温\n" +
                   "\t<field name=\"GHx\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1902") + "]]></field>  //呼吸频率\n" +
                   "\t<field name=\"GMb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1901") + "]]></field>  //脉率\n" +
                   "\t<field name=\"GXyyc1\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1905") + "]]></field>  //右侧收缩压\n" +
                   "\t<field name=\"GXyyc2\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1906") + "]]></field>  //右侧舒张压\n" +
                   "\t<field name=\"GXyzc1\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1903") + "]]></field>  //左侧收缩压\n" +
                   "\t<field name=\"GXyzc2\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1904") + "]]></field>  //左侧舒张压\n" +
                   "\t<field name=\"GSg\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1907") + "]]></field>  //身高\n" +
                   "\t<field name=\"GYw\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1909") + "]]></field>  //腰围\n" +
                   "\t<field name=\"GTzh\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1908") + "]]></field>  //体重\n" +
                   "\t<field name=\"GTzhzh\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1910") + "]]></field>  //体重指数(BMI)\n" +
                   "\t<field name=\"GLnrrz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1913"))+"]]></field>  //1.阴性；2.阳性;\n" +
                   "\t<field name=\"GLnrqg\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1914"))+"]]></field>  //1.阴性；2.阳性;\n" +
                   "\t<field name=\"GLnrrzfen\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1913B") + "]]></field>  //老年人认知能力分数\n" +
                   "\t<field name=\"GLnrqgfen\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1914B") + "]]></field>   //老年人情感能力分数\n" +
                   "\t<field name=\"GZysl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1953") + "]]></field>  //左眼视力\n" +
                   "\t<field name=\"GYysl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1954") + "]]></field>  //右眼视力\n" +
                   "\t<field name=\"GZyjz\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1955") + "]]></field>  //左眼矫正视力\n" +
                   "\t<field name=\"GYyjz\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1956") + "]]></field>  //右眼矫正视力\n" +
                   "\t<field name=\"GTl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1957")) + "]]></field>  // 听 力 1.听见;2.听不清或无法听见（耳鼻喉科专科就诊）;\n" +
                   "\t<field name=\"GYdgn\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1958")) + "]]></field>  // 运动功能 1.可顺利完成;2.无法独立完成其中任何一个动作(上级医院就诊);\n" +
                   "\t<field name=\"GPfgm\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1960")) + "]]></field>  // 皮 肤 1.正常;2.潮红;3.苍白;4.发绀;5.黄染;6.色素沉着;99.其他;\n" +
                   "\t<field name=\"GLbj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1962")) + "]]></field>  // 淋巴结 1.未触及;2.锁骨上;3.腋窝;4.其他;\n" +
                   "\t<field name=\"GLbjqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1962B") + "]]></field>  ///淋巴结其他\n" +
                   "\t<field name=\"GTzx\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1963")) + "]]></field>  //  桶状胸： 1.是;2.否;\n" +
                   "\t<field name=\"GHxy\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1964")) + "]]></field>  // 呼吸音： 1.正常;2.异常;\n" +
                   "\t<field name=\"GHxyyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1964B") + "]]></field>  //呼吸音异常  和字段GHxy有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GLy\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1965")) + "]]></field>  // 罗 音： 1.无;2.干罗音;3.湿罗音;4.其他;\n" +
                   "\t<field name=\"GLyyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1965B") + "]]></field>  //罗音其他\n" +
                   "\t<field name=\"GXinlv\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1966") + "]]></field>  //心率\n" +
                   "\t<field name=\"GXinlvci\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1967")) + "]]></field>  // 心律： 1.齐;2.不齐;3.绝对不齐;\n" +
                   "\t<field name=\"GZayin\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1968")) + "]]></field>  // 杂音： 1.无;2.有;\n" +
                   "\t<field name=\"GZayinyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1968B") + "]]></field>  //有杂音  和字段GZayin有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GYato\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1969")) + "]]></field>  // 压痛： 1.无;2.有;\n" +
                   "\t<field name=\"GYatoyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1969B") + "]]></field>  //有压痛  和字段GYato有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GBk\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1970")) + "]]></field>  // 包块： 1.无;2.有;\n" +
                   "\t<field name=\"GBkyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1970B") + "]]></field>  // 有包块  和字段GBk有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GGanda\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1971")) + "]]></field>  // 肝大： 1.无;2.有;\n" +
                   "\t<field name=\"GGandayo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1971B") + "]]></field>  //有肝大  和字段GGanda有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GPida\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1972")) + "]]></field>  // 脾大： 1.无;2.有;\n" +
                   "\t<field name=\"GPidayo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1972B") + "]]></field>  //有脾大： 和字段GPida有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GZhuoyin\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1973")) + "]]></field>  // 移动性浊音： 1.无;2.有;\n" +
                   "\t<field name=\"GZhuoyinyo\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1973B") + "]]></field>  //有移动性浊音：  和字段GZhuoyin有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GXzsz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1974") )+ "]]></field>  //下肢水肿 1.无;2.左侧;3.右侧;4.双侧不对称;5.双侧对称;\n" +
                   "\t<field name=\"GGmzhzh\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1976")) + "]]></field>  // 肛门指诊 1.未见异常;2.触痛;3.包块;4.前列腺异常;99.其他;\n" +
                   "\t<field name=\"GGmzhzhyi\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1976B") + "]]></field>  //其他肛门指诊  和字段GGmzhzh有关系，当为99时，使用此字段\n" +
                   "\t<field name=\"GQlx\"><![CDATA[]]></field>      // 暂时不对应\n" +
                   "\t<field name=\"GCtqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1983") + "]]></field>  //其他查体 \n" +
                   "\t<field name=\"wbc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9001") + "]]></field>  //血常规-白细胞\n" +
                   "\t<field name=\"hb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9013") + "]]></field>  //血常规-血红蛋白\n" +
                   "\t<field name=\"plt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9018") + "]]></field>  //血常规-血小板\n" +
                   "\t<field name=\"GXcgqt\"><![CDATA[红细胞："+ util.xmlOne(jktjList, "LNCT9012") +",中性细胞粒："+ util.xmlOne(jktjList, "LNCT9007") + ",淋巴细胞："+ util.xmlOne(jktjList, "LNCT9008") +"]]></field>  //血常规-其他\n" +
                   "\t<field name=\"GNdb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9107") + "]]></field>  //尿常规-尿蛋白\n" +
                   "\t<field name=\"GNt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9103") + "]]></field>  //尿常规-尿糖\n" +
                   "\t<field name=\"GNtt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9110")+"]]></field>  //尿常规-尿酮体\n" +
                   "\t<field name=\"GNqx\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9106") + "]]></field>  //尿常规-尿潜血\n" +
                   "\t<field name=\"GNcgqt\"><![CDATA[白细胞："+ util.xmlOne(jktjList, "LNCT9111") +"]]></field>  //尿常规-其他\n" +
                   "\t<field name=\"GDbqx\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9130") )+ "]]></field>  // 大便潜血 1.阴性;2.阳性;\n" +
                   "\t<field name=\"alt\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2001") + "]]></field>  //肝功能-血清谷丙转氨酶\n" +
                   "\t<field name=\"ast\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2002") + "]]></field>  //肝功能-血清谷草转氨酶\n" +
                   "\t<field name=\"alb\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2012") + "]]></field>  //肝功能-白蛋白\n" +
                   "\t<field name=\"tbil\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2008") + "]]></field>  //肝功能-总胆红素\n" +
                   "\t<field name=\"dbil\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2009")+ "]]></field>  //肝功能-结合胆红素\n" +
                   "\t<field name=\"scr\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2016") + "]]></field>  //肾功能-血清肌酐\n" +
                   "\t<field name=\"bun\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2015") + "]]></field>  //肾功能-血尿素氮\n" +
                   "\t<field name=\"cho\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2021") + "]]></field>  //血脂-总胆固醇\n" +
                   "\t<field name=\"tg\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2022") + "]]></field>  //血脂-甘油三酯\n" +
                   "\t<field name=\"ldlc\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2024") + "]]></field>  //血脂-血清低密度脂蛋白胆固醇\n" +
                   "\t<field name=\"hdlc\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2023") + "]]></field>  //血脂-血清高密度脂蛋白胆固醇\n" +
                   "\t<field name=\"GKfxt\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2025") + "]]></field>  //空腹血糖\n" +
                   "\t<field name=\"hbsag\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2134") + "]]></field>  // 乙型肝炎表面抗原 1.阴性;2.阳性;\n" +
                   "\t<field name=\"GYand\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1959")) + "]]></field>  // 眼 底 1.正常;2.异常;\n" +
                   "\t<field name=\"GYandyi\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1959B") + "]]></field>  //眼底异常  和字段GYand有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GXindt\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT8000")) + "]]></field>  // 心电图 1.正常;2.异常; \n" +
                   "\t<field name=\"GXindtyi\"><![CDATA[" + util.xmlOne(jktjList, "LNCT8000B") + "]]></field>  //心电图异常填写  和字段GXindt有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GXiongp\"><![CDATA[]]></field>  // 胸部X线片 1.正常;2.异常;\n" +
                   "\t<field name=\"GXiongpyc\"><![CDATA[]]></field>  //胸部X线片异常  和字段GXiongp有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GBchao\"><![CDATA[" + util.Bchao(util.xmlOne(jktjList, "LNCT8100")) + "]]></field>  // B 超 1.正常;2.异常;\n" +
                   "\t<field name=\"GBchaoyi\"><![CDATA[" + util.BchaoYC(util.xmlOne(jktjList, "LNCT8100" )) + "]]></field>  //B 超异常  和字段GBchao有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GFuzhuqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT8300") + "]]></field>  //辅助检查其他\n" +
                   "\t<field name=\"GJljjy\"><![CDATA[]]></field>  \t//暂时不对应\n" +
                   "\t<field name=\"happentime\"><![CDATA["+util.Datenyr(getTest(id).getPe_date())+"]]></field>  //体检日期\n" +
                   "\t<field name=\"field1\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"field2\"><![CDATA["+getDocutorName(id)+"]]></field>  //责任医生\n" +
                   "\t<field name=\"field3\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"field4\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"GTunwei\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"GYtwbz\"><![CDATA[]]></field>   //暂时不对应\n" +
                   "\t<field name=\"GDlpl\"><![CDATA["+util.xmlOne(jktjList,"LNCT1915")+"]]></field>  // 锻炼频率 1.每天;2.每周一次以上;3.偶尔;4.不锻炼;\n" +
                   "\t<field name=\"GMcdlsj\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1916") + "]]></field>  //每次锻炼时间\n" +
                   "\t<field name=\"GJcdlsj\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1917") + "]]></field>  //坚持锻炼时间\n" +
                   "\t<field name=\"GDlfs\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1918") + "]]></field>  //锻炼方式\n" +
                   "\t<field name=\"GYsxg\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1919")) + "]]></field>  // 饮食习惯 1.荤素均衡;2.荤食为主;3.素食为主;4.嗜盐;5.嗜油;6.嗜糖;\n" +
                   "\t<field name=\"GXyzk\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1920")) + "]]></field>  // 吸烟状况  1.从不吸烟;2.已戒烟;3.吸烟;\n" +
                   "\t<field name=\"GRxyl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1921") + "]]></field>  //日吸烟量\n" +
                   "\t<field name=\"GKsxynl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1922") + "]]></field>  //开始吸烟年龄\n" +
                   "\t<field name=\"GJynl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1923") + "]]></field>  //戒烟年龄\n" +
                   "\t<field name=\"GYjpl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1924")) + "]]></field>  // 饮酒频率 1.从不;2.偶尔;3.经常;4.每天;\n" +
                   "\t<field name=\"GRyjl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1925") + "]]></field>  //日饮酒量\n" +
                   "\t<field name=\"GSfjj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1926")) + "]]></field>  //是否戒酒   1.未戒酒;2.已戒酒;\n" +
                   "\t<field name=\"GJjnl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1927") + "]]></field>  //戒酒年龄\n" +
                   "\t<field name=\"GKsyjnl\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1928") + "]]></field>  //开始饮酒年龄\n" +
                   "\t<field name=\"GYnnsfyj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1929")) + "]]></field>  // 近一年内是否曾醉酒 1.是;2.否;\n" +
                   "\t<field name=\"GYjzl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1930") )+ "]]></field>  // 饮酒种类 1.白酒;2.啤酒;3.红酒;4.黄酒;99.其他;\n" +
                   "\t<field name=\"GYjzlqt\"><![CDATA[]]></field>  //其他饮酒种类   和字段GYjzl有关联，当为99时，使用此字段\n" +
                   "\t<field name=\"GYwzybl\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1931")) + "]]></field>  // 职业病危害因素接触史 1.无;2.有;\n" +
                   "\t<field name=\"GJtzy\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1932") + "]]></field>  //工种  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"GCysj\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1933") + "]]></field>  //从业时间  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"GHxp\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1940") + "]]></field>  //化学物质  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"GHxpfhcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1941")) + "]]></field>  // 职业病危害因素接触史-化学物质-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"GHxpfhcsjt\"><![CDATA[]]></field>  //化学物质措施  和字段GHxpfhcs有关联，当为2时，使用此字段\n" +
                   "\t<field name=\"GDuwu\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"GDwfhcs\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"GDwfhcsqt\"><![CDATA[]]></field>  //暂时不对应\n" +
                   "\t<field name=\"GShexian\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1936") + "]]></field>  //放射物质  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"GSxfhcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1937")) + "]]></field>  // 职业病危害因素接触史-放射物质-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"GSxfhcsqt\"><![CDATA[]]></field>  //放射物质措施 和字段GSxfhcs有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GKouchun\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1950")) + "]]></field>  // 口唇 1.红润;2.苍白;3.发绀;4.皲裂;5.疱疹;6.其他;\n" +
                   "\t<field name=\"GChilei\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1951")) + "]]></field>  // 齿列 1.正常;2.缺齿;3.龋齿;4.义齿(假牙);5.其他;  \n" +
                   "\t<field name=\"GYanbu\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1952")) + "]]></field>  // 咽部 1.无充血;2.充血;3.淋巴滤泡增生;4.其他;\n" +
                   "\t<field name=\"GPfqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1960B") + "]]></field>  //皮 肤其他\n" +
                   "\t<field name=\"GGongmo\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1961")) + "]]></field>  // 巩 膜 1.正常;2.黄染;3.充血;99.其他;\n" +
                   "\t<field name=\"GGmqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1961B") + "]]></field>   // 巩 膜其他\n" +
                   "\t<field name=\"GZbdmmd\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1975")) + "]]></field>  // 足背动脉搏动 1.未触及;2.触及双侧对称;3.触及左侧弱或消失;4.触及右侧弱或消失;\n" +
                   "\t<field name=\"GRuxian\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1977")) + "]]></field>  // 乳 腺 1.未见异常;2.乳房切除;3.异常泌乳;4.乳腺包块;99.其他;\n" +
                   "\t<field name=\"GRuxianqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1977B") + "]]></field>  //其他乳腺  和字段GRuxian有关系，当为99时，使用此字段\n" +
                   "\t<field name=\"GWaiyin\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1978")) + "]]></field>  // 外阴 1.未见异常;2.异常;\n" +
                   "\t<field name=\"GWaiyinyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1978B") + "]]></field>  //外阴异常  和字段GWaiyin有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GYindao\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1979")) + "]]></field>  // 阴道 1.未见异常;2.异常;\n" +
                   "\t<field name=\"GYindaoyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1979B") + "]]></field>  //阴道异常  和字段GYindao有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GGongjing\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1980")) + "]]></field>  // 宫颈 1.未见异常;2.异常;\n" +
                   "\t<field name=\"GGongjingyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1980B") + "]]></field>  //宫颈异常  和字段GGongjing有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GGongti\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1981")) + "]]></field>  // 宫体 1.未见异常;2.异常;\n" +
                   "\t<field name=\"GGongtiyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1981B") + "]]></field>  //宫体异常\n" +
                   "\t<field name=\"GFujian\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1982") )+ "]]></field>  // 附件 1.未见异常;2.异常;\n" +
                   "\t<field name=\"GFujianyc\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1982B") + "]]></field>  //附件异常\n" +
                   "\t<field name=\"GSgnxjnd\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2137") + "]]></field>  //肾功能-血钾浓度\n" +
                   "\t<field name=\"GSgnxnnd\"><![CDATA[" + util.xmlOne(jktjList, "LNCTA2138") + "]]></field>  //肾功能-血钠浓度\n" +
                   "\t<field name=\"GThxhdb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9121") + "]]></field>  //糖化血红蛋白\n" +
                   "\t<field name=\"GGjtp\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT8400")) + "]]></field>  // 宫颈涂片 1.正常;2.异常;\n" +
                   "\t<field name=\"GGjtpyc\"><![CDATA[]]></field>  //宫颈涂片异常  和字段GGjtp有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GPhz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9200")) + "]]></field>  // 平和质 1.是;2.基本是;\n" +
                   "\t<field name=\"GQxz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9201")) + "]]></field>  // 气虚质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GYangxz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9202")) + "]]></field>  // 阳虚质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GYinxz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9203")) + "]]></field>  // 阴虚质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GTsz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9204")) + "]]></field>  // 痰湿质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GSrz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9205")) + "]]></field>  // 湿热质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GXyz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9206"))+ "]]></field>  // 血瘀质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GQyz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9207")) + "]]></field>  // 气郁质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GTbz\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9208")) + "]]></field>  // 特秉质 1.是;2.倾向是;\n" +
                   "\t<field name=\"GNxgjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9300")) + "]]></field>  // 脑血管疾病 1.未发现;2.缺血性卒中;3.脑出血;4.蛛网膜下腔出血;5.短暂性脑缺血发作;99.其他;\n" +
                   "\t<field name=\"GNxgjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9300B")+ "]]></field>   // 脑血管疾病 其他\n" +
                   "\t<field name=\"GSzjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9301")) + "]]></field>  // 肾脏疾病 1.未发现;2.糖尿病肾病;3.肾功能衰竭;4.急性肾炎;5.慢性肾炎;99.其他;\n" +
                   "\t<field name=\"GSzjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9301B")+"]]></field>  // 肾脏疾病其他\n" +
                   "\t<field name=\"GXzjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9302")) + "]]></field>  // 心脏疾病 1.未发现;2.心肌梗死;3.心绞痛;4.冠状动脉血运重建;5.充血性心力衰竭;6.心前区疼痛;99.其他;\n" +
                   "\t<field name=\"GXzjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9302B")+"]]></field>  // 心脏疾病其他\n" +
                   "\t<field name=\"GXgjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9303")) + "]]></field>  // 血管疾病 1.未发现;2.夹层动脉瘤;3.动脉闭塞性疾病;99.其他;\n" +
                   "\t<field name=\"GXgjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9303B")+"]]></field>  // 血管疾病其他\n" +
                   "\t<field name=\"GYbjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9304")) + "]]></field>  //  眼部疾病1.未发现;2.视网膜出血或渗出;3.视乳头水肿;4.白内障;99.其他;\n" +
                   "\t<field name=\"GYbjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9304B") + "]]></field>  //  眼部疾病其他\n" +
                   "\t<field name=\"GSjxtjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9305")) + "]]></field>  // 神经系统疾病 1.未发现;2.有;\n" +
                   "\t<field name=\"GSjxtjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9305B")+"]]></field>  //神经系统疾病有时的填写\n" +
                   "\t<field name=\"GQtxtjb\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9306")) + "]]></field>  // 其他系统疾病 1.未发现;2.有;\n" +
                   "\t<field name=\"GQtxtjbqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9306B")+"]]></field>  //其他系统疾病有时填写\n" +
                   "\t<field name=\"GJkpj\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9460")) + "]]></field>  // 健康评价 1.体检无异常;2.有异常;\n" +
                   "\t<field name=\"GJkpjyc1\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9461") + "]]></field>  //健康评价异常1  和字段GJkpj有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GJkpjyc2\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9462") + "]]></field>  //健康评价异常2  和字段GJkpj有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GJkpjyc3\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9463") + "]]></field>  //健康评价异常3  和字段GJkpj有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GJkpjyc4\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9464") + "]]></field>  //健康评价异常4  和字段GJkpj有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"GJkzd\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT9465")) + "]]></field>  // 健康指导 1.定期随访;2.纳入慢性病管理;3.建议复查;4.建议转诊;\n" +
                   "\t<field name=\"GWxyskz\"><![CDATA[" + util.wxys(util.number(util.xmlOne(jktjList, "LNCT9466")))+"]]></field>  // 危险因素控制 1.戒烟;2.健康饮酒;3.饮食;4.锻炼;97.减体重;98.建议疫苗接种;99.其他;\n" +
                   "\t<field name=\"GWxystz\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9467") + "]]></field>  //危险因素控制  目标填写\n" +
                   "\t<field name=\"GWsysym\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9468") + "]]></field>  //危险因素控制建议疫苗接种 填写\n" +
                   "\t<field name=\"GWxysqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9469") + "]]></field>  //危险因素控制其他  填写\n" +
                   "\t<field name=\"field5\"><![CDATA[]]></field>  //暂不对应\n" +
                   "\t<field name=\"GZzqt\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1000B") +"]]></field>  //其他症状    和字段GZhzh有联系，当为99时，使用此字段\n" +
                   "\t<field name=\"GXyyc\"><![CDATA[]]></field>  //不对应\n" +
                   "\t<field name=\"GXyzc\"><![CDATA[]]></field>  //不对应\n" +
                   "\t<field name=\"GQtzhzh\"><![CDATA[]]></field>  //不对应\n" +
                   "\t<field name=\"qdqxz\"><![CDATA[]]></field>  //不对应\n" +
                   "\t<field name=\"info\"><![CDATA[]]></field>   //不对应\n" +
                   "\t<field name=\"kchqt\"><![CDATA[]]></field>  //口唇其他  和字段GKouchun有关系，当为6时，使用此字段\n" +
                   "\t<field name=\"chlqt\"><![CDATA[]]></field>  //齿列其他  \n" +
                   "\t<field name=\"ybqt\"><![CDATA[]]></field>  //咽部其他  和字段GYanbu有关系，当为4时，使用此字段\n" +
                   "\t<field name=\"ydgnqt\"><![CDATA[]]></field>  //不对应\n" +
                   "\t<field name=\"wzd\"><![CDATA[]]></field>   //不对应\n" +
                   "\t<field name=\"GChxt\"><![CDATA[]]></field>  //餐后2H血糖\n" +
                   "\t<field name=\"lnrzkpg\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1911")) + "]]></field>  // 老年人健康状态自我评估 1.满意;2.基本满意;3.说不清楚;4.不太满意;5.不满意;\n" +
                   "\t<field name=\"lnrzlpg\"><![CDATA[" + util.number1(util.number(util.xmlOne(jktjList, "LNCT1912"))) + "]]></field>  // 老年人生活自理能力自我评估 1.可自理(0～3分);2.轻度依赖(4～8分);3.中度依赖(9～18分);4.不能自理(≥19分);\n" +
                   "\t<field name=\"fenchen\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1934") + "]]></field>  //粉尘  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"wuliyinsu\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1938") + "]]></field>  //物理因素 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"blqita\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1942") + "]]></field>  //职业病危害因素接触史 其他  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"fchcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1935")) + "]]></field>  // 职业病危害因素接触史-粉尘-防护措施  1.无;2.有;  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"wlcs\"><![CDATA[" + util.number(util.xmlOne(jktjList, "LNCT1939")) + "]]></field>  // 职业病危害因素接触史-物理因素-防护措施 1.无;2.有; 和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"blqtcs\"><![CDATA[" + util.number(util.xmlOne(jktjList,"LNCT1943")) + "]]></field>  // 职业病危害因素接触史-其他-防护措施 1.无;2.有;  和字段GYwzybl有关联，当为3时，使用此字段\n" +
                   "\t<field name=\"fchY\"><![CDATA[]]></field>  //粉尘措施  和字段fchcs有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"wlY\"><![CDATA[]]></field>  //物理因素措施  和字段wlcs有关系，当为2时，使用此字段\n" +
                   "\t<field name=\"qtY\"><![CDATA[]]></field>  //职业病危害因素接触史-其他措施  和字段blqtcs有关联，当为2时，使用此字段\n" +
                   "\t<field name=\"tnbfxjf\"><![CDATA[]]></field>  //不对应\n" +
                   "\t<field name=\"zcyy\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1904B") + "]]></field>  //左侧原因\n" +
                   "\t<field name=\"ycyy\"><![CDATA[" + util.xmlOne(jktjList, "LNCT1906B") + "]]></field>  //右侧原因\n" +
                   "\t<field name=\"nwlbdb\"><![CDATA[" + util.xmlOne(jktjList, "LNCT9112") + "]]></field>  //尿微量白蛋白 \n" +
                   "\t<field name=\"DJkbs\"><![CDATA[]]></field>  //不对应\n" +
                   "    <field name=\"GClque\"><![CDATA["+ util.yc(util.xmlOne(jktjList, "LNCT1951C")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951B")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951E") )+"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951D")) +"]]></field>  //缺齿\n" +
                   "    <field name=\"GClqu\"><![CDATA["+ util.yc(util.xmlOne(jktjList, "LNCT1951G")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951F")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951I")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951H") )+"]]></field>  //龋齿\n" +
                   "<field name=\"GClyi\"><![CDATA["+ util.yc(util.xmlOne(jktjList, "LNCT1951K") )+"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951J")) + "@"+util.yc(util.xmlOne(jktjList, "LNCT1951M")) +"@"+ util.yc(util.xmlOne(jktjList, "LNCT1951L")) +"]]></field>  //义齿(假牙)\n" +
                   "<field name=\"Ysqmzz\"><![CDATA["+getDocutorName(id)+"]]></field>  //医师签名-症状\n" +
                   "<field name=\"Ysqm_zz\"><![CDATA["+getDocutorName(id)+"]]></field>  //医师签名-症状\n" +
                   "</subrow>   "+
                   "    </row>\n" +
                   "</XMLTOPERSONS>";
           WebService factory =  new WebService();
           WebServicePortType webServiceHttpPort = factory.getWebServiceHttpPort();
           String hello = webServiceHttpPort.dataCenterWebservice("3B86EDC086794717A76AAD14ED0A0AA6","645f9b7b405141b789359086ab5860d0",xml1);
           return hello;
       }
        return "你输入的用户没有数据！";
    }


}
