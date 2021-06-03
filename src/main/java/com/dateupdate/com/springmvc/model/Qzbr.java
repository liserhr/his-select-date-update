package com.dateupdate.com.springmvc.model;

public class Qzbr {
    private Integer sort;
    private String name;
    private String signData;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "sort=" + sort +
                ", name='" + name + '\'' +
                ", signData='" + signData + '\'' +
                '}';
    }
}
