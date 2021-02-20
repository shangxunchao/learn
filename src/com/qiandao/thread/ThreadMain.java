/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.thread;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.qiandao.model.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/7 11:11
 **/
public class ThreadMain {

	private static Log log = LogFactory.getLog(ThreadMain.class);
	private static Random random = new Random();

	public static void main(String[] args) {
		List<Student> result = getStudent();
		log.info(String.format("first print,res=%s", JSON.toJSONString(result)));
		log.info("##################");
		log.info(String.format("second print,res=%s", JSON.toJSONString(result)));
		log.info("##################");
		/*CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> randomDelay());
		completableFuture.acceptEither(CompletableFuture.supplyAsync(() -> randomDelay()), u -> System.out.println(u)).join();
		ClassA classA = new ClassA(1, "test");
		System.out.println(JSON.parseObject(JSON.toJSONString(classA), ClassB.class).toString());
		System.out.println(String.format("we%s", 1));*/
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info(String.format("the third time print,res=%s", JSON.toJSONString(result)));
	}

	/**
	 * <a href="http://www.slf4j.org/codes.html#loggerNameMismatch">Detected
	 * logger name mismatch</a>
	 *
	 * @return
	 */
	public static String randomDelay() {

		int delay = 500 + random.nextInt(2000);
		try {
			System.out.println(String.format("%s sleep in %d", Thread.currentThread().getName(), delay));
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("%s sleep in %s", Thread.currentThread().getName(), "end"));
		return Thread.currentThread().getName() + " return";
	}

	private static List<Student> getStudent() {
		CountDownLatch latch = new CountDownLatch(2);
		List<Student> students = new ArrayList<>(2);
		ThreadPoolUtils.homeThirdExecutor.execute(() -> {
			try {
				log.info(String.format("test 1 start, threadName=%s", Thread.currentThread().getName()));
				Student student = new Student("test 1", 1);
				TimeUnit.SECONDS.sleep(1);
				students.add(student);
				log.info(String.format("test 1 end, threadName=%s", Thread.currentThread().getName()));
			} catch (Exception e) {
				log.error(String.format("test 1 error, threadName=%s", Thread.currentThread().getName()), e);
			} finally {
				log.info(String.format("test 1 countDown, threadName=%s", Thread.currentThread().getName()));
				latch.countDown();
			}
		});

		ThreadPoolUtils.homeThirdExecutor.execute(() -> {
			try {
				log.info(String.format("test 2 start, threadName=%s", Thread.currentThread().getName()));
				Student student = new Student("test 2", 2);
				TimeUnit.SECONDS.sleep(2);
				students.add(student);
				log.info(String.format("test 2 end, threadName=%s", Thread.currentThread().getName()));
			} catch (Exception e) {
				log.error(String.format("test 2 error, threadName=%s", Thread.currentThread().getName()), e);
			} finally {
				log.info(String.format("test 2 countDown, threadName=%s", Thread.currentThread().getName()));
				latch.countDown();
			}
		});

		try {
			log.info("thread count=" + latch.getCount());
			Long now = System.currentTimeMillis();
			Stopwatch stopwatch = Stopwatch.createStarted();
			log.info("await start time=" + now);
			latch.await(800, TimeUnit.MILLISECONDS);
			log.info("stopwatch end time=" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
			log.info("await end time=" + (System.currentTimeMillis() - now));
			log.info("await end, count=" + latch.getCount());
		} catch (InterruptedException e) {
			log.error(String.format("await error, threadName=%s", Thread.currentThread().getName()));
		}
		log.info(String.format("main method end, res = %s, threadName=%s", JSON.toJSONString(students), Thread.currentThread().getName()));
		return students;
	}
}