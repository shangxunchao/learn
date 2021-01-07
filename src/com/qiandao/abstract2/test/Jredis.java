/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.abstract2.test;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/12/10 11:10
 **/
public abstract class Jredis {
	public abstract void demo(Redis redis);

	public void demo2() {
		Redis redis = new Redis();
		demo(redis);
	}
}