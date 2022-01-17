package com.example.a14_recyclerviewdragandswipejava.model;

public class Member {
    private String tv_name;
    private String tv_tel_number;

    public Member(String tv_name, String tv_tel_number) {
        this.tv_name = tv_name;
        this.tv_tel_number = tv_tel_number;
    }

    public String getTv_tel_number() {
        return tv_tel_number;
    }

    public String getTv_name() {
        return tv_name;
    }
}
