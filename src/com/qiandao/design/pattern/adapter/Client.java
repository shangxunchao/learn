/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.adapter;

/**
 * <p>TODO
 * </p>
 * 适配器（Adapter）
 * 把一个类接口转换成另一个用户需要的接口。
 *
 * @author shangxunchao
 * @date 2021/2/24 17:57
 **/
public class Client {
	public static void main(String[] args) {
		Turkey turkey = new WildTurkey();
		Duck duck = new TurkeyAdapter(turkey);
		duck.quack();
	}
}