/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn.thread;

import com.alibaba.fastjson.JSON;
import com.qiandao.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/11/4 14:55
 **/
public class FutureDemo {
	private static ExecutorService executorService =
			new ThreadPoolExecutor(5, 6,
					1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(100),
					new ThreadPoolExecutor.CallerRunsPolicy());

	public static void main(String[] args) {
		Future<List<Student>> listFuture = executorService.submit(() -> Dd3("d3-", 1, 2));
		Future<List<Student>> listFuture2 = executorService.submit(new D2("d2-", 2, 3));
		List<Student> te = new ArrayList<>();
		try {
			if (listFuture2.get() != null) {
				te.addAll(listFuture2.get());
			}
			if (listFuture.get(2, TimeUnit.SECONDS) != null) {
				te.addAll(listFuture.get());
			}
			System.out.println(JSON.toJSONString(te));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} finally {
			if (!executorService.isShutdown()) {
				System.out.println("shutdown");
				executorService.shutdown();
				System.out.println("after_shutdown");
			}
			System.out.println("end");
		}
	}


	private static class D1 implements Callable<List<Student>> {
		private String name;
		private Integer score;
		private Integer age;

		public D1(String name, Integer score, Integer age) {
			this.name = name;
			this.score = score;
			this.age = age;
		}

		@Override
		public List<Student> call() throws Exception {
			List<Student> students = new ArrayList<>();
			Student student = new Student();
			student.setName(name);
			student.setScore(score);
			student.setAge(age);
			students.add(student);
			TimeUnit.SECONDS.sleep(5);
			return students;
		}
	}

	public static class D2 implements Callable<List<Student>> {
		private String name;
		private Integer score;
		private Integer age;

		public D2(String name, Integer score, Integer age) {
			this.name = name;
			this.score = score;
			this.age = age;
		}

		@Override
		public List<Student> call() throws Exception {
			List<Student> students = new ArrayList<>();
			Student student = new Student();
			student.setName(name + "D2");
			student.setScore(score);
			student.setAge(age);
			students.add(student);
			TimeUnit.SECONDS.sleep(5);
			return students;
		}
	}

	private static List<Student> Dd3(String name, Integer score, Integer age) {
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		student.setName(name + "D3");
		student.setScore(score);
		student.setAge(age);
		students.add(student);
		return students;
	}

}