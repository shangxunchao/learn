/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.abstract2.test;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/12/10 11:11
 **/
public class Luccen {
    public static void main(String[] args) {
        System.out.println("Luccen start");
        new Jredis() {
            @Override
            public void demo(Redis redis) {
                System.out.println(redis.getId() + " " + "Luccen");
            }
        }.demo2();
    }
}