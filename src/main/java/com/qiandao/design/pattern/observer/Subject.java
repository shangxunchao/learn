/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.observer;

/**
 * <p>TODO
 * </p>
 * 观察者模式（Observer）
 * 主题（Subject）是被观察的对象，而其所有依赖者（Observer）称为观察者。
 *
 * @author shangxunchao
 * @date 2021/2/24 17:17
 **/
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}