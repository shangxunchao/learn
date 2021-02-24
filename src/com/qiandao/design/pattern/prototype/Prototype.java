/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.prototype;

/**
 * <p>TODO
 * </p>
 * 原型模式：使用原型实例指定要创建对象的类型，通过复制这个原型来创建新对象。
 *
 * @author shangxunchao
 * @date 2021/2/24 16:32
 **/
public abstract class Prototype {
	abstract Prototype myClone();
}