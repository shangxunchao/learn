/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.singleton;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 15:36
 **/
public class Singleton2 {
	private Singleton2() {
	}

	private static class SingletonHolder {
		private static final Singleton2 INSTANCE = new Singleton2();
	}

	public static Singleton2 getUniqueInstance() {
		return SingletonHolder.INSTANCE;
	}
}