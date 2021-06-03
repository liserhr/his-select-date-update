
package com.dateupdate.com.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServicePortType", targetNamespace = "http://webservice.jiekou.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServicePortType {


    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "testWebService", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.TestWebService")
    @ResponseWrapper(localName = "testWebServiceResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.TestWebServiceResponse")
    public String testWebService(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "selecttdaJkdaRkxzl", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelecttdaJkdaRkxzl")
    @ResponseWrapper(localName = "selecttdaJkdaRkxzlResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelecttdaJkdaRkxzlResponse")
    public String selecttdaJkdaRkxzl(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveMzzl", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzl")
    @ResponseWrapper(localName = "saveMzzlResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlResponse")
    public String saveMzzl(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveZyzlJyxq", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlJyxq")
    @ResponseWrapper(localName = "saveZyzlJyxqResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlJyxqResponse")
    public String saveZyzlJyxq(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveMzzlHyxm", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlHyxm")
    @ResponseWrapper(localName = "saveMzzlHyxmResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlHyxmResponse")
    public String saveMzzlHyxm(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveZyzlCyzd", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlCyzd")
    @ResponseWrapper(localName = "saveZyzlCyzdResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlCyzdResponse")
    public String saveZyzlCyzd(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "selectptsj", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.Selectptsj")
    @ResponseWrapper(localName = "selectptsjResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectptsjResponse")
    public String selectptsj(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveTpwRgin", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveTpwRgin")
    @ResponseWrapper(localName = "saveTpwRginResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveTpwRginResponse")
    public String saveTpwRgin(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveZyzl", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzl")
    @ResponseWrapper(localName = "saveZyzlResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlResponse")
    public String saveZyzl(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveZyzlHyxm", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlHyxm")
    @ResponseWrapper(localName = "saveZyzlHyxmResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlHyxmResponse")
    public String saveZyzlHyxm(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "returnCardNum", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ReturnCardNum")
    @ResponseWrapper(localName = "returnCardNumResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ReturnCardNumResponse")
    public String returnCardNum(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveZyzlFy", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlFy")
    @ResponseWrapper(localName = "saveZyzlFyResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlFyResponse")
    public String saveZyzlFy(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "tongBuManBing", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.TongBuManBing")
    @ResponseWrapper(localName = "tongBuManBingResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.TongBuManBingResponse")
    public String tongBuManBing(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveMzzlFy", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlFy")
    @ResponseWrapper(localName = "saveMzzlFyResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlFyResponse")
    public String saveMzzlFy(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "manbingjieshou", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.Manbingjieshou")
    @ResponseWrapper(localName = "manbingjieshouResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ManbingjieshouResponse")
    public String manbingjieshou(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "getDict", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.GetDict")
    @ResponseWrapper(localName = "getDictResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.GetDictResponse")
    public String getDict(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveZyzlSszd", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlSszd")
    @ResponseWrapper(localName = "saveZyzlSszdResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveZyzlSszdResponse")
    public String saveZyzlSszd(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @param in2
     * @param in1
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "DataCenterWebservice")
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "DataCenterWebservice", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.DataCenterWebservice")
    @ResponseWrapper(localName = "DataCenterWebserviceResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.DataCenterWebserviceResponse")
    public String dataCenterWebservice(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0,
        @WebParam(name = "in1", targetNamespace = "http://webservice.jiekou.com")
        String in1,
        @WebParam(name = "in2", targetNamespace = "http://webservice.jiekou.com")
        String in2);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveTpwUser", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveTpwUser")
    @ResponseWrapper(localName = "saveTpwUserResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveTpwUserResponse")
    public String saveTpwUser(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "returnOrgList", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ReturnOrgList")
    @ResponseWrapper(localName = "returnOrgListResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ReturnOrgListResponse")
    public String returnOrgList();

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "returnJtysYygl", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ReturnJtysYygl")
    @ResponseWrapper(localName = "returnJtysYyglResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.ReturnJtysYyglResponse")
    public String returnJtysYygl(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveYszz", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveYszz")
    @ResponseWrapper(localName = "saveYszzResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveYszzResponse")
    public String saveYszz(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveMzzlJyxq", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlJyxq")
    @ResponseWrapper(localName = "saveMzzlJyxqResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveMzzlJyxqResponse")
    public String saveMzzlJyxq(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "selectZd", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectZd")
    @ResponseWrapper(localName = "selectZdResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectZdResponse")
    public String selectZd(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "selectGztx", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectGztx")
    @ResponseWrapper(localName = "selectGztxResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectGztxResponse")
    public String selectGztx(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "updateJtysYyglAppointStatus", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.UpdateJtysYyglAppointStatus")
    @ResponseWrapper(localName = "updateJtysYyglAppointStatusResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.UpdateJtysYyglAppointStatusResponse")
    public String updateJtysYyglAppointStatus(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "sendNotice", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SendNotice")
    @ResponseWrapper(localName = "sendNoticeResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SendNoticeResponse")
    public String sendNotice(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveJtysYygl", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveJtysYygl")
    @ResponseWrapper(localName = "saveJtysYyglResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveJtysYyglResponse")
    public String saveJtysYygl(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "tongBuManBingNew", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.TongBuManBingNew")
    @ResponseWrapper(localName = "tongBuManBingNewResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.TongBuManBingNewResponse")
    public String tongBuManBingNew(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

    /**
     * 
     * @param in0
     * @param in1
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "selectGwtz", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectGwtz")
    @ResponseWrapper(localName = "selectGwtzResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SelectGwtzResponse")
    public String selectGwtz(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0,
        @WebParam(name = "in1", targetNamespace = "http://webservice.jiekou.com")
        String in1);

    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.jiekou.com")
    @RequestWrapper(localName = "saveTDaJkdaRkxzl", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveTDaJkdaRkxzl")
    @ResponseWrapper(localName = "saveTDaJkdaRkxzlResponse", targetNamespace = "http://webservice.jiekou.com", className = "com.dateupdate.com.webService.SaveTDaJkdaRkxzlResponse")
    public String saveTDaJkdaRkxzl(
        @WebParam(name = "in0", targetNamespace = "http://webservice.jiekou.com")
        String in0);

}
