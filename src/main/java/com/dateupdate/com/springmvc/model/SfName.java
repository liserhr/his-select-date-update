package com.dateupdate.com.springmvc.model;

public class SfName {
    private String UserName;
    private String SfNumber;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSfNumber() {
        return SfNumber;
    }

    public void setSfNumber(String sfNumber) {
        SfNumber = sfNumber;
    }

    @Override
    public String toString() {
        return "SfName{" +
                "UserName='" + UserName + '\'' +
                ", SfNumber='" + SfNumber + '\'' +
                '}';
    }
}
