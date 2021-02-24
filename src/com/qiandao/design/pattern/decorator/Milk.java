/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.decorator;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 18:12
 **/
public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return 1 + beverage.cost();
	}
}