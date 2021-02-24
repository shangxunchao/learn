/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.strategy;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 17:40
 **/
public class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("quack!");
	}
}