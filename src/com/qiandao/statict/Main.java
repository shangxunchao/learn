/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.statict;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/18 12:00
 **/
public class Main implements as {
	public static void main(String[] args) {
		List<String> stringArrayList = new ArrayList<String>();
		List<Integer> integerArrayList = new ArrayList<Integer>();

		Class classStringArrayList = stringArrayList.getClass();
		Class classIntegerArrayList = integerArrayList.getClass();

		if (classStringArrayList.equals(classIntegerArrayList)) {
			System.out.println(classStringArrayList);
			System.out.println(classIntegerArrayList);
		}
		Main main = new Main();
		main.de();
	}

	@Override
	public void de() {
		final int totalThread = 10;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < totalThread; i++) {
			executorService.execute(() -> {
				System.out.println(Thread.currentThread().getName() + " before..");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " after..");
			});
		}
		executorService.shutdown();
	}
}