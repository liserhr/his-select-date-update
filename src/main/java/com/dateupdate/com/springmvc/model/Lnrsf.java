package com.dateupdate.com.springmvc.model;

import java.util.Date;
import java.sql.Timestamp;

public class Lnrsf {
    private String patientNo;

    private Integer itemValue1;

    private Integer itemValue2;

    private Integer itemValue3;

    private Integer itemValue4;

    private Integer itemValue5;

    private Integer status;

    private Integer operatorId;

    private Timestamp operateDate;

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public Integer getItemValue1() {
        return itemValue1;
    }

    public void setItemValue1(Integer itemValue1) {
        this.itemValue1 = itemValue1;
    }

    public Integer getItemValue2() {
        return itemValue2;
    }

    public void setItemValue2(Integer itemValue2) {
        this.itemValue2 = itemValue2;
    }

    public Integer getItemValue3() {
        return itemValue3;
    }

    public void setItemValue3(Integer itemValue3) {
        this.itemValue3 = itemValue3;
    }

    public Integer getItemValue4() {
        return itemValue4;
    }

    public void setItemValue4(Integer itemValue4) {
        this.itemValue4 = itemValue4;
    }

    public Integer getItemValue5() {
        return itemValue5;
    }

    public void setItemValue5(Integer itemValue5) {
        this.itemValue5 = itemValue5;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        if (operatorId == null ) {
            this.operatorId = 0;
        }else {
            this.operatorId = operatorId;
        }
    }

    public Timestamp getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Timestamp operateDate) {
        this.operateDate = operateDate;
    }

    @Override
    public String toString() {
        return "Lnrsf{" +
                "patientNo='" + patientNo + '\'' +
                ", itemValue1=" + itemValue1 +
                ", itemValue2=" + itemValue2 +
                ", itemValue3=" + itemValue3 +
                ", itemValue4=" + itemValue4 +
                ", itemValue5=" + itemValue5 +
                ", status=" + status +
                ", operatorId=" + operatorId +
                ", operateDate=" + operateDate +
                '}';
    }
}