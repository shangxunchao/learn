/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn.dynamic.proxy.cglib;

import com.qiandao.learn.proxyStatic.UserManager;
import com.qiandao.model.Student;
import com.qiandao.sorts.add.Main;

import java.util.Objects;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/26 16:27
 **/
public class UserManagerImpl extends Main implements UserManager {

    @Override
    public void addUser(String userId, String userName) {
        System.out.println("UserManagerImpl.addUser");
    }

    @Override
    public void delUser(String userId) {
        System.out.println("UserManagerImpl.delUser");
    }

    @Override
    public String findUser(String userId) {
        System.out.println("UserManagerImpl.findUser");
        return "张三";
    }

    @Override
    public void modifyUser(String userId, String userName) {
        System.out.println("UserManagerImpl.modifyUser");

    }
}