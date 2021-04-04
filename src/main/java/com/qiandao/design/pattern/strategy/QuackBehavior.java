/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.strategy;

/**
 * <p>TODO
 * </p>
 * 策略:定义一系列算法，封装每个算法，并使它们可以互换。
 *
 * @author shangxunchao
 * @date 2021/2/24 17:40
 **/
public interface QuackBehavior {
    void quack();
}