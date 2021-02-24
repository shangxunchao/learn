/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.adapter;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 17:56
 **/
public class TurkeyAdapter implements Duck {
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}
}