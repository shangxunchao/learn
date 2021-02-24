/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.strategy;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 17:41
 **/
public class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("squeak!");
	}
}