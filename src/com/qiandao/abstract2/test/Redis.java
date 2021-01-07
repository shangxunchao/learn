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
public class Redis {
	Redis() {
		System.out.println("redis");
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}