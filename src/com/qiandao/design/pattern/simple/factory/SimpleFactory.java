/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.simple.factory;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 15:47
 **/
public class SimpleFactory {
	public Product createProduct(int type) {
		if (type == 1) {
			return new ConcreteProduct1();
		} else if (type == 2) {
			return new ConcreteProduct2();
		}
		return new ConcreteProduct();
	}
}