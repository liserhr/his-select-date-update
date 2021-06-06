package com.dateupdate.com.springmvc.model;

public class Other {
    private String username;
    private String tjh;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTjh() {
        return tjh;
    }

    public void setTjh(String tjh) {
        this.tjh = tjh;
    }

    @Override
    public String toString() {
        return "Other{" +
                "username='" + username + '\'' +
                ", tjh='" + tjh + '\'' +
                '}';
    }
}
