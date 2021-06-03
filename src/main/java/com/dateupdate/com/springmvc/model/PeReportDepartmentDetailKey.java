package com.dateupdate.com.springmvc.model;

public class PeReportDepartmentDetailKey {
    private String patientNo;

    private Integer departmentId;

    private String composeItemNo;

    private String itemNo;

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getComposeItemNo() {
        return composeItemNo;
    }

    public void setComposeItemNo(String composeItemNo) {
        this.composeItemNo = composeItemNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }
}