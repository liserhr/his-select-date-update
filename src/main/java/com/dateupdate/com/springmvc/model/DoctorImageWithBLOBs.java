package com.dateupdate.com.springmvc.model;

import com.dateupdate.com.springmvc.model.DoctorImage;

import java.util.Arrays;

public class DoctorImageWithBLOBs extends DoctorImage {
    private byte[] signImage;

    private byte[] photoImage;

    public byte[] getSignImage() {
        return signImage;
    }

    public void setSignImage(byte[] signImage) {
        this.signImage = signImage;
    }

    public byte[] getPhotoImage() {
        return photoImage;
    }

    public void setPhotoImage(byte[] photoImage) {
        this.photoImage = photoImage;
    }

    @Override
    public String toString() {
        return "DoctorImageWithBLOBs{" +
                "signImage=" + Arrays.toString(signImage) +
                ", photoImage=" + Arrays.toString(photoImage) +
                '}';
    }
}