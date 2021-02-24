/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.template.method;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 17:48
 **/
public class Coffee extends CaffeineBeverage {
	@Override
	void brew() {
		System.out.println("Coffee.brew");
	}

	@Override
	void addCondiments() {
		System.out.println("Coffee.addCondiments");
	}
}