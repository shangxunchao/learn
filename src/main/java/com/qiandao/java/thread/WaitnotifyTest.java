package com.qiandao.java.thread;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/28 11:34
 */
public class WaitnotifyTest {

    public static volatile boolean shouldChildren = false;

    public static void main(String[] args) throws Exception {
        final Outputer outputer = new Outputer();

        //创建子线程
        Thread chrild = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 2; i++)
                        outputer.children();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        chrild.start();
        //主线程
        for (int i = 0; i < 2; i++)
            outputer.main();
    }
}


class Outputer {
    //子线程循环输出
    public synchronized void children() throws Exception {
        while (!WaitnotifyTest.shouldChildren) {
            System.out.println(Thread.currentThread().getName()
                    + " thread end loop,go to waitting");
            //子线程进入等待状态
            this.wait();
        }

        System.out.println(Thread.currentThread().getName()
                + " thread start loop");
        for (int i = 1; i <= 3; i++) {
            System.out.println("hello,i am chrildren thread,loop:" + i);
        }

        WaitnotifyTest.shouldChildren = false;
        //唤醒主线程
        this.notify();
    }

    //主线程循环输出
    public synchronized void main() throws Exception {
        while (WaitnotifyTest.shouldChildren) {
            System.out.println(Thread.currentThread().getName()
                    + " thread end loop,go to waitting");
            //主线程进入等待状态
            this.wait();
        }

        System.out.println(Thread.currentThread().getName()
                + " thread start loop");
        for (int i = 1; i <= 3; i++) {
            System.out.println("hello,i am main thread,loop:" + i);
        }

        WaitnotifyTest.shouldChildren = true;
        //唤醒子线程
        this.notify();
    }
}
