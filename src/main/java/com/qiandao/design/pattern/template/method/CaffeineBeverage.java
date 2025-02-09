/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.template.method;

/**
 * <p>TODO
 * </p>
 * 模板方法:定义算法框架，并将一些步骤的实现延迟到子类。
 * 通过模板方法，子类可以重新定义算法的某些步骤，而不用改变算法的结构。
 * 冲咖啡和冲茶都有类似的流程，但是某些步骤会有点不一样，要求复用那些相同步骤的代码
 *
 * @author shangxunchao
 * @date 2021/2/24 17:47
 **/
public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("boilWater");
    }

    void pourInCup() {
        System.out.println("pourInCup");
    }
}