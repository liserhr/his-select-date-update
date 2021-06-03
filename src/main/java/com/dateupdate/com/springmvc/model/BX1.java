package com.dateupdate.com.springmvc.model;

import java.util.Arrays;

public class BX1 {
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BX1{" +
                "image=" + Arrays.toString(image) +
                '}';
    }
}
