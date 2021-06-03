package com.dateupdate.com.springmvc.model;

import java.util.Date;

public class PeReportDepartmentDetail extends PeReportDepartmentDetailKey {
    private Integer resultClassId;

    private String peResult;

    private Boolean isAbnormity;

    private Integer abortReasonId;

    private Integer operatorId;

    private Date operateDate;

    private Integer resultFlag;

    private Double normalUp;

    private Double normalDown;

    private String normalPrint;

    private Integer reportOperatorId;

    private Integer reportCheckOperatorId;

    private Date reportDate;

    public Integer getResultClassId() {
        return resultClassId;
    }

    public void setResultClassId(Integer resultClassId) {
        this.resultClassId = resultClassId;
    }

    public String getPeResult() {
        return peResult;
    }

    public void setPeResult(String peResult) {
        this.peResult = peResult;
    }

    public Boolean getIsAbnormity() {
        return isAbnormity;
    }

    public void setIsAbnormity(Boolean isAbnormity) {
        this.isAbnormity = isAbnormity;
    }

    public Integer getAbortReasonId() {
        return abortReasonId;
    }

    public void setAbortReasonId(Integer abortReasonId) {
        this.abortReasonId = abortReasonId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public Integer getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(Integer resultFlag) {
        this.resultFlag = resultFlag;
    }

    public Double getNormalUp() {
        return normalUp;
    }

    public void setNormalUp(Double normalUp) {
        this.normalUp = normalUp;
    }

    public Double getNormalDown() {
        return normalDown;
    }

    public void setNormalDown(Double normalDown) {
        this.normalDown = normalDown;
    }

    public String getNormalPrint() {
        return normalPrint;
    }

    public void setNormalPrint(String normalPrint) {
        this.normalPrint = normalPrint;
    }

    public Integer getReportOperatorId() {
        return reportOperatorId;
    }

    public void setReportOperatorId(Integer reportOperatorId) {
        this.reportOperatorId = reportOperatorId;
    }

    public Integer getReportCheckOperatorId() {
        return reportCheckOperatorId;
    }

    public void setReportCheckOperatorId(Integer reportCheckOperatorId) {
        this.reportCheckOperatorId = reportCheckOperatorId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {


        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "PeReportDepartmentDetail{" +
                "resultClassId=" + resultClassId +
                ", peResult='" + peResult + '\'' +
                ", isAbnormity=" + isAbnormity +
                ", abortReasonId=" + abortReasonId +
                ", operatorId=" + operatorId +
                ", operateDate=" + operateDate +
                ", resultFlag=" + resultFlag +
                ", normalUp=" + normalUp +
                ", normalDown=" + normalDown +
                ", normalPrint='" + normalPrint + '\'' +
                ", reportOperatorId=" + reportOperatorId +
                ", reportCheckOperatorId=" + reportCheckOperatorId +
                ", reportDate=" + reportDate +
                '}';
    }
}