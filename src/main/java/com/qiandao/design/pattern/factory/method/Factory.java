/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.factory.method;

import com.qiandao.design.pattern.simple.factory.Product;

/**
 * <p>TODO
 * </p>
 * 工厂方法
 *
 * @author shangxunchao
 * @date 2021/2/24 15:53
 **/
public abstract class Factory {
    abstract public Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();
        // do something with the product
    }
}