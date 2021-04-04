/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.model;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/13 10:28
 **/
public class ClassA {
    private Integer c_Id;
    private String c_Name;

    public Integer getC_Id() {
        return c_Id;
    }

    public void setC_Id(Integer c_Id) {
        this.c_Id = c_Id;
    }

    public String getC_Name() {
        return c_Name;
    }

    public void setC_Name(String c_Name) {
        this.c_Name = c_Name;
    }

    public ClassA(Integer c_Id, String c_Name) {
        this.c_Id = c_Id;
        this.c_Name = c_Name;
    }

    public ClassA() {
    }
}