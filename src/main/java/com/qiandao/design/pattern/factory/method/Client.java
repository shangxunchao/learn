/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.factory.method;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 16:00
 **/
public class Client {
    public void doSomething() {
        Factory factory = new ConcreteFactory();
        factory.doSomething();
        // do something with the product
    }
}