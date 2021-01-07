package com.qiandao.java.thread;

import org.junit.Test;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/9/30 11:36
 */
public class InterruptTest {

	@Test
	public void demo1(){

		Thread thread = new Thread(() -> {
			while (true) {
				Thread.yield();
				System.out.println("是否中断："+Thread.currentThread().isInterrupted());
			}
		});
		thread.start();
		thread.interrupt();
	}

	@Test
	public void demo2(){

		Thread thread = new Thread(() -> {
			while (true) {
				Thread.yield();

				// 响应中断
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Java技术栈线程被中断，程序退出。");
					return;
				}
			}
		});
		thread.start();
		thread.interrupt();
	}

	@Test
	public void demo3() throws InterruptedException {

		Thread thread = new Thread(() -> {
			while (true) {
				// 响应中断
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Java技术栈线程被中断，程序退出。");
					return;
				}else{
					System.out.println("Java技术栈线程中断失败！");
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Java技术栈线程休眠被中断，程序退出。");
				}
			}
		});
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
	}

	@Test
	public void demo4() throws InterruptedException {

		Thread thread = new Thread(() -> {
			while (true) {
				// 响应中断
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Java技术栈线程被中断，程序退出。");
					return;
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println("Java技术栈线程休眠被中断，程序退出。");
					Thread.currentThread().interrupt();
				}
			}
		});
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
	}

	@Test
	public void demo5(){

		Runnable runnable = () -> {
			System.out.println("Java技术栈线程线程组名称：" + Thread.currentThread().getThreadGroup());
			System.out.println("Java技术栈线程线程名称：" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		ThreadGroup userGroup = new ThreadGroup("user");
		userGroup.setMaxPriority(Thread.MIN_PRIORITY);

		Thread userTask1 = new Thread(userGroup, runnable, "user-task1");
		Thread userTask2 = new Thread(userGroup, runnable, "user-task2");

		userTask1.start();
		userTask2.start();

		System.out.println("Java技术栈线程线程组活跃线程数：" + userGroup.activeCount());
		userGroup.list();
	}

	@Test
	public void demo6(){

		Runnable runnable = () -> {
			for (int i = 0; i <= 100; i++) {
				System.out.println(Thread.currentThread().getName() + "-----" + i);
				if (i % 20 == 0) {
					Thread.yield();
				}
			}
		};
		new Thread(runnable, "栈长").start();
		new Thread(runnable, "小蜜").start();
	}

	@Test
	public void demo7(){

		Object lock = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				for (int i = 0; i < 20; i++) {
					System.out.print(i+" ");
					if (i == 10) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("erroe");
					e.printStackTrace();
				}
				System.out.print("Java技术栈");
				lock.notifyAll();
			}
		});
		t1.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
	}

	@Test
	public void demo8(){


		Thread t1 = new Thread(() -> {
			synchronized (this) {
				for (int i = 0; i < 20; i++) {
					System.out.print(i+" ");
					if (i == 10) {
						try {
							this.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			synchronized (this) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("erroe");
					e.printStackTrace();
				}
				System.out.print("Java技术栈");
				this.notifyAll();
			}
		});
		t1.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
	}

}
