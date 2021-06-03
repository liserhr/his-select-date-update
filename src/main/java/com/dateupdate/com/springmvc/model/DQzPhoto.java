package com.dateupdate.com.springmvc.model;

import java.util.Arrays;

public class DQzPhoto {
    private String UserName;
    private String XMName;
    private byte[] SignImage;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getXMName() {
        return XMName;
    }

    public void setXMName(String XMName) {
        this.XMName = XMName;
    }

    public byte[] getSignImage() {
        return SignImage;
    }

    public void setSignImage(byte[] signImage) {
        SignImage = signImage;
    }

    @Override
    public String toString() {
        return "DQzPhoto{" +
                "username='" + UserName + '\'' +
                ", XMName='" + XMName + '\'' +
                ", SignImage=" + Arrays.toString(SignImage) +
                '}';
    }
}
