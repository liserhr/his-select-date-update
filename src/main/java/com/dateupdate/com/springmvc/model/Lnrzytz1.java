package com.dateupdate.com.springmvc.model;

public class Lnrzytz1 {
    private String patientNo;

    private Integer abnormityId1;

    private Integer abnormityId2;

    private Integer abnormityId3;

    private Integer abnormityId4;

    private Integer abnormityId5;

    private Integer abnormityId6;

    private Integer abnormityId7;

    private Integer abnormityId8;

    private Integer abnormityId9;

    private String advice;

    private Integer status;

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        if (patientNo == null){
            this.patientNo = "";
        }else {
            this.patientNo = patientNo;
        }
    }

    public String getAbnormityId1() {
        if (abnormityId1 == 0){
            return "";
        }else {
            return abnormityId1.toString();
        }
    }

    public void setAbnormityId1(Integer abnormityId1) {
        if (abnormityId1 == null){
            this.abnormityId1 = 0;
        }else {
            this.abnormityId1 = abnormityId1;
        }
    }

    public String getAbnormityId2() {
        if (abnormityId2 == 0){
            return "";
        }else {
            return abnormityId2.toString();
        }
    }

    public void setAbnormityId2(Integer abnormityId2) {
        if (abnormityId2 == null){
            this.abnormityId2 = 0;
        }else {
            this.abnormityId2 = abnormityId2;
        }
    }

    public String getAbnormityId3() {
        if (abnormityId3 == 0){
            return "";
        }else {
            return abnormityId3.toString();
        }
    }

    public void setAbnormityId3(Integer abnormityId3) {
        if (abnormityId3 == null){
            this.abnormityId3 = 0;
        }else {
            this.abnormityId3 = abnormityId3;
        }

    }

    public String getAbnormityId4() {
        if (abnormityId4 == 0){
            return "";
        }else {
            return abnormityId4.toString();
        }
    }

    public void setAbnormityId4(Integer abnormityId4) {
        if (abnormityId4 == null){
            this.abnormityId4 = 0;
        }else {
            this.abnormityId4 = abnormityId4;
        }

    }

    public String getAbnormityId5() {
        if (abnormityId5 == 0){
            return "";
        }else {
            return abnormityId5.toString();
        }
    }

    public void setAbnormityId5(Integer abnormityId5) {
        if (abnormityId5 == null){
            this.abnormityId5 = 0;
        }else {
            this.abnormityId5 = abnormityId5;
        }

    }

    public String getAbnormityId6() {
        if (abnormityId6 == 0){
            return "";
        }else {
            return abnormityId6.toString();
        }
    }

    public void setAbnormityId6(Integer abnormityId6) {
        if (abnormityId6 == null){
            this.abnormityId6 = 0;
        }else {
            this.abnormityId6 = abnormityId6;
        }
    }

    public String getAbnormityId7() {
        if (abnormityId7 == 0){
            return "";
        }else {
            return abnormityId7.toString();
        }
    }

    public void setAbnormityId7(Integer abnormityId7) {
        if (abnormityId7 == null){
            this.abnormityId7 = 0;
        }else {
            this.abnormityId7 = abnormityId7;
        }
    }

    public String getAbnormityId8() {
        if (abnormityId8 == 0){
            return "";
        }else {
            return abnormityId8.toString();
        }
    }

    public void setAbnormityId8(Integer abnormityId8) {
        if (abnormityId8 == null){
            this.abnormityId8 = 0;
        }else {
            this.abnormityId8 = abnormityId8;
        }
        }

    public String getAbnormityId9() {
        if (abnormityId9 == 0){
            return "";
        }else {
            return abnormityId9.toString();
        }
    }

    public void setAbnormityId9(Integer abnormityId9) {
        if (abnormityId9 == null){
            this.abnormityId9 = 0;
        }else {
            this.abnormityId9 = abnormityId9;
        }
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        if (advice == null){
            this.advice = "";
        }else {
            this.advice = advice;
        }
    }

    public String getStatus() {
        if (status == 0){
            return "";
        }else {
            return status.toString();
        }
    }

    public void setStatus(Integer status) {
        if (status == null){
            this.status = 0;
        }else {
            this.status = status;
        }
    }
}