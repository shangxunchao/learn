/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.factory.method;

import com.qiandao.design.pattern.simple.factory.ConcreteProduct;
import com.qiandao.design.pattern.simple.factory.Product;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 15:54
 **/
public class ConcreteFactory extends Factory {
	@Override
	public Product factoryMethod() {
		return new ConcreteProduct();
	}
}