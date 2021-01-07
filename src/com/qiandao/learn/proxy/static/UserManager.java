/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn.proxyStatic;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/26 16:26
 **/
public interface UserManager {

	void addUser(String userId, String userName);

	void delUser(String userId);

	String findUser(String userId);

	void modifyUser(String userId, String userName);
}