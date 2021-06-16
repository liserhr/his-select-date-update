package com.dateupdate.com.springmvc.model;

public class Qzbr {
    private Integer operationSort;
    private String signName;
    private String signData;


    public Integer getOperationSort() {
        return operationSort;
    }

    public void setOperationSort(Integer operationSort) {
        this.operationSort = operationSort;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    @Override
    public String toString() {
        return "Qzbr{" +
                "sort=" + operationSort +
                ", name='" + signName + '\'' +
                ", signData='" + signData + '\'' +
                '}';
    }
}
