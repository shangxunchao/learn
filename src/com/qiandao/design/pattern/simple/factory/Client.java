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
public class Client {
	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		Product product = simpleFactory.createProduct(1);
		// do something with the product
	}
}