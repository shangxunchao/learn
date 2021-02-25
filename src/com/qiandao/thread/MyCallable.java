/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/25 14:54
 **/
public class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() {
		System.out.println("call: " + Thread.currentThread().getName());
		return 123;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		MyCallable mc = new MyCallable();
		FutureTask<Integer> ft = new FutureTask<>(mc);
		Thread thread = new Thread(ft);
		thread.start();
		System.out.println(ft.get());
		System.out.println("main: " + Thread.currentThread().getName());
	}
}