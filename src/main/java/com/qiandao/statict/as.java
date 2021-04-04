/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.statict;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/18 15:06
 **/
public interface as {
    void de();

    default void de2() {
        System.out.println("de2");
    }
}