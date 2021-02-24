/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.prototype;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 16:32
 **/
public class ConcretePrototype extends Prototype {
	private String filed;

	public ConcretePrototype(String filed) {
		this.filed = filed;
	}

	@Override
	Prototype myClone() {
		return new ConcretePrototype(filed);
	}

	@Override
	public String toString() {
		return filed;
	}
}