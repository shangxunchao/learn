/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn;

import java.util.List;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/26 10:49
 **/
public class TestMain<T> {

    private List<T> notStaticList;

    private List<T> staticList;

    private T ifThenElse(boolean b, T first, T second) {

        return b ? first : second;

    }

}