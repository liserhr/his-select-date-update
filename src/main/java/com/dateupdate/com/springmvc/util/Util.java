package com.dateupdate.com.springmvc.util;

import com.dateupdate.com.springmvc.model.*;
import com.dateupdate.com.springmvc.service.impl.JktjServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.font.CreatedFontTracker;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    // xml中每个数据的值
    public String xmlOne(List<ListOne> list, String filename){
        for (ListOne listOne : list){
         if (listOne.getItemNo().equals(filename)){
          return listOne.getPeResult();
         }
        }
        return null;
    }

    // B超异常判断
    public String xmlOneOther(List<ListOne> list, String filename,String other){
        for (ListOne listOne : list){
            if (listOne.getItemNo().equals(filename)){
                String result = listOne.getPeResult();
                if (result.contains("异常")){
                    return xmlOne(list,other);
                }else{
                    return null;
                }
            }
        }
        return null ;
    }

    // 只留下数字
    public  String  number(String str){
        if (str!=null) {
            StringBuffer b = new StringBuffer();
            StringBuffer c = new StringBuffer();
            int num = 0;
            String regex = "\\d+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(str);
            while (m.find()) {
                String s = m.group();
                b.append(s + ",");
                num++;
            }
            String str1 = b.toString();
            char[] chars = str1.toCharArray();
            int num1 = chars.length-1-1;
            for (int i=0;i<=num1;i++){
                c.append(chars[i]);
            }
            return c.toString();

        }
        return "";
    }

    public String number1 (String result){
        if (result.equals("1,0,3")){
            return "1";
        }else if (result.equals("2,4,8")){
            return "2";
        }else if (result.equals("3,9,18")){
            return "3";
        }else {
            return "4";
        }
    }

    public String Bchao(String result){
        if (result.equals("正常")){
            return "1";
        }else{
            return "2";
        }

    }

    public String BchaoYC(String result){
        if (result.equals("正常")){
            return null;
        }else{
            return result;
        }
    }

    // 住院史，用药史,接种史
    public String  MoreOrOne(List<ListOne> list, String id, Date date){
        StringBuffer a = new StringBuffer();
        JktjServiceImpl service = new JktjServiceImpl();
                // 住院史
                  String result = xmlOne(list,"LNCT9400")+xmlOne(list,"LNCT9401")+xmlOne(list,"LNCT9403")+xmlOne(list,"LNCT9404")+xmlOne(list,"LNCT9405");
        //System.out.println(result.length() == 0);
                  if (result .length() != 0){
                      a.append("\t<subrow name=\"T_TJ_ZYZLQKB\">  //住院治疗情况,包括住院史和家庭病床史\n" +
                              "\t\t<field name=\"ZType\"><![CDATA[1]]></field>  //1.住院情况2.家庭病床史，添加和删除住院史的控制字段\n" +
                              "\t\t<field name=\"ZRyjcrq\"><![CDATA[" + xmlOne(list, "LNCT9400") + "]]></field>  //入院日期\n" +
                              "\t\t<field name=\"ZCyccrq\"><![CDATA[" + xmlOne(list, "LNCT9401") + "]]></field>  //出院日期\n" +
                              "\t\t<field name=\"ZYuanyin\"><![CDATA[" + xmlOne(list, "LNCT9403") + "]]></field>  //原 因\n" +
                              "\t\t<field name=\"ZYljgmc\"><![CDATA[" + xmlOne(list, "LNCT9404") + "]]></field>  //医疗机构名称\n" +
                              "\t\t<field name=\"ZBingah\"><![CDATA[" + xmlOne(list, "LNCT9405") + "]]></field>  //病案号\n" +
                              "\t\t<field name=\"ZHappentime\"><![CDATA["+date+"]]></field>  //发生时间\n" +
                              "\t</subrow>  \n" );
                  }
                  String result1 = xmlOne(list,"LNCT9406")+xmlOne(list,"LNCT9407")+xmlOne(list,"LNCT9408")+xmlOne(list,"LNCT9409")+xmlOne(list,"LNCT94010");
                if (result1.length() != 0){
                    a.append( "\t<subrow name=\"T_TJ_ZYZLQKB\">  //住院治疗情况,包括住院史和家庭病床史\n" +
                            "\t\t<field name=\"ZType\"><![CDATA[1]]></field>  //添加和删除住院史的控制字段\n" +
                            "\t\t<field name=\"ZRyjcrq\"><![CDATA[" + xmlOne(list, "LNCT9406") + "]]></field>  //入院日期\n" +
                            "\t\t<field name=\"ZCyccrq\"><![CDATA[" + xmlOne(list, "LNCT9407") + "]]></field>  //出院日期\n" +
                            "\t\t<field name=\"ZYuanyin\"><![CDATA[" + xmlOne(list, "LNCT9408") + "]]></field>  //原 因\n" +
                            "\t\t<field name=\"ZYljgmc\"><![CDATA[" + xmlOne(list, "LNCT9409") + "]]></field>  //医疗机构名称\n" +
                            "\t\t<field name=\"ZBingah\"><![CDATA[" + xmlOne(list, "LNCT9410") + "]]></field>  //病案号\n" +
                            "\t\t<field name=\"ZHappentime\"><![CDATA["+date+"]]></field>  //发生时间\n" +
                            "\t</subrow>  \n" );
                }
                // 用药史
                String result2 = xmlOne(list,"LNCT9421");
                if (result2.length() != 0){
                    a.append("\t<subrow name=\"T_TJ_YYQKB\">  //主要用药情况1\n" +
                            "\t\t<field name=\"YYwmc\"><![CDATA[" + xmlOne(list, "LNCT9421") + "]]></field>  //药物名称\n" +
                            "\t\t<field name=\"YYongfa\"><![CDATA[" + xmlOne(list, "LNCT9422") + "]]></field>  //用法\n" +
                            "\t\t<field name=\"YYongl\"><![CDATA[" + xmlOne(list, "LNCT9423") + "]]></field>  //用量\n" +
                            "\t\t<field name=\"YYysj\"><![CDATA[" + xmlOne(list, "LNCT9424") + "]]></field>  //用药时间\n" +
                            "\t\t<field name=\"YFyycx\"><![CDATA[" + xmlOne(list, "LNCT9425") + "]]></field>  //服药依从性\n" +
                            "\t\t<field name=\"YHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                            "\t</subrow>  \n" );
                }
                String result3 = xmlOne(list,"LNCT9426");
        if (result3 .length() != 0){
            a.append("\t<subrow name=\"T_TJ_YYQKB\">  //主要用药情况2\n" +
                    "\t\t<field name=\"YYwmc\"><![CDATA[" + xmlOne(list, "LNCT9426") + "]]></field>  //药物名称\n" +
                    "\t\t<field name=\"YYongfa\"><![CDATA[" + xmlOne(list, "LNCT9427") + "]]></field>  //用法\n" +
                    "\t\t<field name=\"YYongl\"><![CDATA[" + xmlOne(list, "LNCT9428") + "]]></field>  //用量\n" +
                    "\t\t<field name=\"YYysj\"><![CDATA[" + xmlOne(list, "LNCT9429") + "]]></field>  //用药时间\n" +
                    "\t\t<field name=\"YFyycx\"><![CDATA[" + xmlOne(list, "LNCT9430") + "]]></field>  //服药依从性\n" +
                    "\t\t<field name=\"YHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow>  \n" );
        }
        String result4 = xmlOne(list,"LNCT9431");
        if (result4.length() != 0){
            a.append( "\t<subrow name=\"T_TJ_YYQKB\">  //主要用药情况3\n" +
                    "\t\t<field name=\"YYwmc\"><![CDATA[" + xmlOne(list, "LNCT9431") + "]]></field>  //药物名称\n" +
                    "\t\t<field name=\"YYongfa\"><![CDATA[" + xmlOne(list, "LNCT9432") + "]]></field>  //用法\n" +
                    "\t\t<field name=\"YYongl\"><![CDATA[" + xmlOne(list, "LNCT9433") + "]]></field>  //用量\n" +
                    "\t\t<field name=\"YYysj\"><![CDATA[" + xmlOne(list, "LNCT9434") + "]]></field>  //用药时间\n" +
                    "\t\t<field name=\"YFyycx\"><![CDATA[" + xmlOne(list, "LNCT9435") + "]]></field>  //服药依从性\n" +
                    "\t\t<field name=\"YHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow>  \n" );
        }
        String result5 = xmlOne(list,"LNCT9436");
        if (result5 .length() != 0){
            a.append(  "\t<subrow name=\"T_TJ_YYQKB\">  //主要用药情况4\n" +
                    "\t\t<field name=\"YYwmc\"><![CDATA[" + xmlOne(list, "LNCT9436") + "]]></field>  //药物名称\n" +
                    "\t\t<field name=\"YYongfa\"><![CDATA[" + xmlOne(list, "LNCT9437") + "]]></field>  //用法\n" +
                    "\t\t<field name=\"YYongl\"><![CDATA[" + xmlOne(list, "LNCT9438") + "]]></field>  //用量\n" +
                    "\t\t<field name=\"YYysj\"><![CDATA[" + xmlOne(list, "LNCT9439") + "]]></field>  //用药时间\n" +
                    "\t\t<field name=\"YFyycx\"><![CDATA[" + xmlOne(list, "LNCT9440") + "]]></field>  //服药依从性\n" +
                    "\t\t<field name=\"YHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow>  \n" );
        }
        String result6 = xmlOne(list,"LNCT9441");
        if (result6 .length() != 0){
            a.append("\t<subrow name=\"T_TJ_YYQKB\">  //主要用药情况5\n" +
                    "\t\t<field name=\"YYwmc\"><![CDATA[" + xmlOne(list, "LNCT9441") + "]]></field>  //药物名称\n" +
                    "\t\t<field name=\"YYongfa\"><![CDATA[" +xmlOne(list, "LNCT9442") + "]]></field>  //用法\n" +
                    "\t\t<field name=\"YYongl\"><![CDATA[" + xmlOne(list, "LNCT9443") + "]]></field>  //用量\n" +
                    "\t\t<field name=\"YYysj\"><![CDATA[" + xmlOne(list, "LNCT9444") + "]]></field>  //用药时间\n" +
                    "\t\t<field name=\"YFyycx\"><![CDATA[" + xmlOne(list, "LNCT9445") + "]]></field>  //服药依从性\n" +
                    "\t\t<field name=\"YHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow>  \n" );
        }

        String result7 = xmlOne(list,"LNCT9446");
        if (result7.length() != 0){
            a.append( "\t<subrow name=\"T_TJ_YYQKB\">  //主要用药情况6\n" +
                    "\t\t<field name=\"YYwmc\"><![CDATA[" + xmlOne(list, "LNCT9446") + "]]></field>  //药物名称\n" +
                    "\t\t<field name=\"YYongfa\"><![CDATA[" + xmlOne(list, "LNCT9447") + "]]></field>  //用法\n" +
                    "\t\t<field name=\"YYongl\"><![CDATA[" + xmlOne(list, "LNCT9448") + "]]></field>  //用量\n" +
                    "\t\t<field name=\"YYysj\"><![CDATA[" + xmlOne(list, "LNCT9449") + "]]></field>  //用药时间\n" +
                    "\t\t<field name=\"YFyycx\"><![CDATA[" + xmlOne(list, "LNCT9450") + "]]></field>  //服药依从性\n" +
                    "\t\t<field name=\"YHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow>  \n" );
        }

        String result8 = xmlOne(list,"LNCT9451");
        if (result8 .length() != 0){
            a.append("\t<subrow name=\"T_TJ_FMYGHYFB1\">  //非免疫规划预防接种史1 \n" +
                    "\t\t\t<field name=\"FJzmc\"><![CDATA[" + xmlOne(list, "LNCT9451") + "]]></field>  //接种名称\n" +
                    "\t\t<field name=\"FJzrq\"><![CDATA[" + xmlOne(list, "LNCT9452") + "]]></field>  //接种日期\n" +
                    "\t\t<field name=\"FJzjg\"><![CDATA[" + xmlOne(list, "LNCT9453") + "]]></field>  //接种机构\n" +
                    "\t\t<field name=\"FHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow>   \n" );
        }
        String result9 = xmlOne(list,"LNCT9454");
        if (result9.length() != 0){
            a.append(     "\t<subrow name=\"T_TJ_FMYGHYFB2\">  //非免疫规划预防接种史2\n" +
                    "\t\t\t<field name=\"FJzmc\"><![CDATA[" + xmlOne(list, "LNCT9454") + "]]></field>  //接种名称\n" +
                    "\t\t<field name=\"FJzrq\"><![CDATA[" + xmlOne(list, "LNCT9455") + "]]></field>  //接种日期\n" +
                    "\t\t<field name=\"FJzjg\"><![CDATA[" + xmlOne(list, "LNCT9456") + "]]></field>  //接种机构\n" +
                    "\t\t<field name=\"FHappentime\"><![CDATA["+date+"]]></field>   //发生时间\n" +
                    "\t</subrow> \n" );
        }
                // 接种史
        return a.toString();
    }
// 老年人随访记分
    public int xmlLnrsf(Lnrsf list,int fileName ){
        switch (fileName){
            case 1:
                if (list.getItemValue1().equals(1)){
                    return 0;
                }else if (list.getItemValue1().equals(2)){
                    return 0;
                }else if (list.getItemValue1().equals(3)){
                    return 3;
                }else if (list.getItemValue1().equals(4)){
                    return 5;
                }
            case 2:
                if (list.getItemValue2().equals(1)){
                    return 0;
                }else if (list.getItemValue2().equals(2)){
                    return 1;
                }else if (list.getItemValue2().equals(3)){
                    return 3;
                }else if (list.getItemValue2().equals(4)){
                    return 7;
                }

            case 3:
                if (list.getItemValue3().equals(1)){
                    return 0;
                }else if (list.getItemValue3().equals(2)){
                    return 0;
                }else if (list.getItemValue3().equals(3)){
                    return 3;
                }else if (list.getItemValue3().equals(4)){
                    return 5;
                }

            case 4:
                if (list.getItemValue4().equals(1)){
                    return 0;
                }else if (list.getItemValue4().equals(2)){
                    return 1;
                }else if (list.getItemValue4().equals(3)){
                    return 5;
                }else if (list.getItemValue4().equals(4)){
                    return 10;
                }

            case 5:
                if (list.getItemValue5().equals(1)){
                    return 0;
                }else if (list.getItemValue5().equals(2)){
                    return 1;
                }else if (list.getItemValue5().equals(3)){
                    return 5;
                }else if (list.getItemValue5().equals(4)){
                    return 10;
                }
        }
        return 0;
    }

// 老年人中医体质，来确定答案的方法

    // 将二进制装换成base64
    public static String getImageString(byte[] data)  {
        BASE64Encoder encoder = new BASE64Encoder();
        return data != null ? encoder.encode(data) : "";
    }
    public static String getBase641(byte[] bytes){
        String baes =getImageString(bytes);
        byte[] erjinzhi = baes.getBytes();
        String base64 =getImageString(erjinzhi);
        return base64;
    }
    public static String getBase64(byte[] bytes){
        String baes =getImageString(bytes);
        return baes;
    }
    // 生成UUID的方法
    public String UUID(){
        String Str1=UUID.randomUUID().toString().replace("-", "");
        return Str1;
    }
    // 上传项目医生签名照片的时候，有些照片没有有些照片有了需要查出来将其拼接到相应的字符串中，
    // 所以这个方法是生成相应的xml字符串块
    public String PhotoXml(List<DQzPhoto> list  ){
        StringBuffer str = new StringBuffer();
        for (DQzPhoto  photo : list){
         if (photo.getXMName().equals("LNCT1001") && photo.getSignImage() != null){// 无
            str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                    "                <field name=\"filename\">"+UUID()+"</field>\n" +
                    "                <field name=\"signcolumn\">ysqm_zz</field>\n" +
                    "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                    "            </subrow>\n"+
                    "<subrow name=\"T_PW_PICFILE\">\n" +
                            "                <field name=\"filename\">"+UUID()+"</field>\n" +
                            "                <field name=\"signcolumn\">ysqm_zqgn</field>\n" +
                            "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                            "            </subrow>\n"+
                    "<subrow name=\"T_PW_PICFILE\">\n" +
                    "                <field name=\"filename\">"+UUID()+"</field>\n" +
                    "                <field name=\"signcolumn\">ysqm_fzjc_qt</field>\n" +
                    "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                    "            </subrow>\n"+
                    "<subrow name=\"T_PW_PICFILE\">\n" +
                    "                <field name=\"filename\">"+UUID()+"</field>\n" +
                    "                <field name=\"signcolumn\">ysqm_ct_yd</field>\n" +
                    "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                    "            </subrow>\n"+
                    "<subrow name=\"T_PW_PICFILE\">\n" +
                    "                <field name=\"filename\">"+UUID()+"</field>\n" +
                    "                <field name=\"signcolumn\">ysqm_ct_cg</field>\n" +
                    "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                    "            </subrow>\n"+
                    "<subrow name=\"T_PW_PICFILE\">\n" +
                    "                <field name=\"filename\">"+UUID()+"</field>\n" +
                    "                <field name=\"signcolumn\">ysqm_ct_qt</field>\n" +
                    "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                    "            </subrow>\n");
         }
            if (photo.getXMName().equals("LNCT1000") && photo.getSignImage() != null){//有
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_ybqk</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1023") && photo.getSignImage() != null){//有
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_shfs</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1011") && photo.getSignImage() != null){// 没查出来
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_1to5</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1012") && photo.getSignImage() != null){//没查出来
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_6to12</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1006") && photo.getSignImage() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_xdt</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1014") && photo.getSignImage() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_xbxxp</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1015") && photo.getSignImage() != null){//无
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_fbbc</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n"+
                        "<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_bc_qt</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1016") && photo.getSignImage() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fzjc_gjtp</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1019") && photo.getSignImage() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_jkwtzyzl</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n"+
                        "<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_zyyyqk</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1021") && photo.getSignImage() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_fmyghyfjzs</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getXMName().equals("LNCT1022") && photo.getSignImage() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_jkpj</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n"+
                        "<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">ysqm_jkzd</field>\n" +
                        "                <field name=\"picture\">"+getImageString(photo.getSignImage())+"</field>\n" +
                        "            </subrow>\n");
            }
        }
        return str.toString();
    }
// 本人签字，家属签字，反馈人签字
    public String Qzbr(List<Qzbr> list){
        StringBuffer str = new StringBuffer();
        for (Qzbr photo : list){
            if (photo.getSignName().equals("PATIENT") && photo.getSignData() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">jgfk_brqz</field>\n" +
                        "                <field name=\"picture\">"+photo.getSignData()+"</field>\n" +
                        "            </subrow>\n");
            }if (photo.getSignName().equals("PATIENT2") && photo.getSignData() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">jgfk_jsqz</field>\n" +
                        "                <field name=\"picture\">"+photo.getSignData()+"</field>\n" +
                        "            </subrow>\n");
            }
            if (photo.getSignName().equals("DOCTOR") && photo.getSignData() != null){
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "                <field name=\"filename\">"+UUID()+"</field>\n" +
                        "                <field name=\"signcolumn\">jgfk_fkrqz</field>\n" +
                        "                <field name=\"picture\">"+ photo.getSignData()+"</field>\n" +
                        "            </subrow>\n");
            }
        }
        return str.toString();
    }

    // 将数据库查出来的日期，分割成年月日
    public String Datenyr(Date date){
        String strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return strNow1;
    }

    // 将数据库查出来的时间，分割成年月日时分秒
    public String Datesfm(Date date){
        String strNow1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return strNow1;
    }

    //B超图片心电图相关
    public String bx(List<BX> list,String id){
        StringBuffer str = new StringBuffer();
        ArrayList<BX> num1 = new ArrayList();
        ArrayList<BX> num2 = new ArrayList();
        for (BX bx:list){

            if (bx.getDepartmentId().equals(9)){
                num1.add(bx);
            }
            if (bx.getDepartmentId().equals(8)){
                num2.add(bx);
            }
        }
        if (num1.size() != 0) {
            for (int i = 0; i < num1.size(); i++) {
                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "<field name=\"DGrdabh\"><![CDATA[]]></field>\n" +
                        "<field name=\"filename\"><![CDATA[" + id + "bc" + (i+1) + "]]></field>//文件名称\n" +
                        "<field name=\"tablename\"><![CDATA[T_JK_JKTJ]]></field>//表名\n" +
                        "<field name=\"signcolumn\"><![CDATA[bctp]]></field>文件类型名  B超图片\n" +
                        "<field name=\"picture\"><![CDATA[" + getImageString(num1.get(i).getImageData()) + "]]></field>//文件64码\n" +
                        "        </subrow>\n");
            }
        }
        if (num2.size() != 0) {
            for (int i = 0; i < num1.size(); i++) {

                str.append("<subrow name=\"T_PW_PICFILE\">\n" +
                        "<field name=\"DGrdabh\"><![CDATA[]]></field>\n" +
                        "<field name=\"filename\"><![CDATA[" + id + "xdt" + (i+1) + "]]></field>//文件名称\n" +
                        "<field name=\"tablename\"><![CDATA[T_JK_JKTJ]]></field>//表名\n" +
                        "<field name=\"signcolumn\"><![CDATA[xdttp]]></field>文件类型名  心电图图片\n" +
                        "<field name=\"picture\"><![CDATA[" + getImageString(num2.get(i).getImageData()) + "]]></field>//文件64码\n" +
                        "        </subrow>\n");
            }
        }


        return str.toString();
    }

    // 危险因素因素，，意外数值转换
    public String wxys(String test){
        StringBuffer str =  new StringBuffer();
        StringBuffer c =  new StringBuffer();
        String [] a =test.split(",");
        for(int i = 0;i<a.length;i++){
            if (a[i] .equals("5")){

                a[i]="97";
            }
            if (a[i] .equals("6")){
                a[i]="98";
            }
            if (a[i] .equals("7")){
                a[i]="99";
            }
        }
        for (int i=0;i<a.length;i++){
            str.append(a[i]+",");

        }
        String str1 = str.toString();
        char[] chars = str1.toCharArray();
        int num1 = chars.length-1-1;
        for (int i=0;i<=num1;i++){
            c.append(chars[i]);
        }

        return c.toString();
    }

    // 症状
    public String zz(String test){
        StringBuffer str =  new StringBuffer();
        StringBuffer c =  new StringBuffer();
        String [] a =test.split(",");
        for(int i = 0;i<a.length;i++){
            if (a[i] .equals("25")){

                a[i]="99";
            }

        }
        for (int i=0;i<a.length;i++){
            str.append(a[i]+",");

        }
        String str1 = str.toString();
        char[] chars = str1.toCharArray();
        int num1 = chars.length-1-1;
        for (int i=0;i<=num1;i++){
            c.append(chars[i]);
        }

        return c.toString();
    }

    // 牙齿
    public String yc(String str){
        if (str==null || str.equals("") || str.equals(" ") ){
            return "0";
        }
        return str;

    }

    public String yesno(String str ){
        if ("有异常".equals(str)){
            return "2";
        }else{
            return "1";
        }
    }


    public String yesno2(String lnct1931) {
        if ("无".equals(lnct1931)){
            return "1";
        }else{
            return  "2";

        }
    }

    public String shizhiall(String str ){
        if ("否".equals(str)){
            return "";
        }else {
            if("是".equals(str)) {
                return "1";
            }else {
                return "2";
            }
        }
    }

    public String xdt(String xdt){
        if ("9".equals(xdt)||"99".equals(xdt) ){
            xdt = "2";
        }
        return  xdt;
    }
}
