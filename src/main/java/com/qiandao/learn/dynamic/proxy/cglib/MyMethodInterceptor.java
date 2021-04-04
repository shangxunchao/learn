/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn.dynamic.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/29 14:49
 **/
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before 前置通知");
        Object result = null;

        try {
            result = methodProxy.invokeSuper(obj, args);
        } catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
            throw ex;
        } finally {
            System.out.println("after 后置通知");
        }
        return result;
    }


}