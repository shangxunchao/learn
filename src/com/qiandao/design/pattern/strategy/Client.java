/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.strategy;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 17:42
 **/
public class Client {
	public static void main(String[] args) {
		Duck duck = new Duck();
		duck.setQuackBehavior(new Squeak());
		duck.performQuack();
		duck.setQuackBehavior(new Quack());
		duck.performQuack();
	}
}