package com.dateupdate.com.springmvc.model;

import java.util.Arrays;

public class BX {
    private Integer departmentId;
    private byte[] imageDate;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public byte[] getImageData() {
        return imageDate;
    }

    public void setImageData(byte[] imageDate) {
        this.imageDate = imageDate;
    }

    @Override
    public String toString() {
        return "BX{" +
                "departmentId=" + departmentId +
                ", imageDate=" + Arrays.toString(imageDate) +
                '}';
    }
}
