/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/23 15:39
 **/

import java.util.Objects;

public class MQTest {

	private String userName;

	private String password;

	private Integer age;

	/*
	 * 构造方法
	 */
	public MQTest(String userName, String password, Integer age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	//重写hashCode() 和equals()方法
	@Override
	public int hashCode() {
		return Objects.hash(userName, password, age);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MQTest mqTest = (MQTest) o;
		return Objects.equals(userName, mqTest.userName) &&
				Objects.equals(password, mqTest.password) &&
				Objects.equals(age, mqTest.age);
	}

}