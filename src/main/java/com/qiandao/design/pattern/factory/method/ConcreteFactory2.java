/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.factory.method;

import com.qiandao.design.pattern.simple.factory.ConcreteProduct2;
import com.qiandao.design.pattern.simple.factory.Product;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 15:55
 **/
public class ConcreteFactory2 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}