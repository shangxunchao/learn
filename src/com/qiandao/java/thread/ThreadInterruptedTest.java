package com.qiandao.java.thread;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/27 18:13
 */
public class ThreadInterruptedTest extends Thread {
	@Override
	public void run() {
		try {
			int i = 0;
			while(!isInterrupted()) {
				i ++ ;
				Thread.sleep(1000);
				System.out.println(this.getName() + " is looping,i=" + i);
			}
		} catch (InterruptedException e) {
			System.out.println(this.getName() +
					" catch InterruptedException,state:" + this.getState());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		ThreadInterruptedTest thread = new ThreadInterruptedTest();
		System.out.println(thread.getName()
				+ " state:" + thread.getState());

		thread.start();
		System.out.println(thread.getName()
				+ " state:" + thread.getState());

		Thread.sleep(5000);

		System.out.println("flag: " + thread.isInterrupted());

		//发出中断指令
		thread.interrupt();

		System.out.println("flag: " + thread.isInterrupted());

		System.out.println(thread.getName()
				+ " state:" + thread.getState());

		System.out.println(thread.interrupted());
	}
}
