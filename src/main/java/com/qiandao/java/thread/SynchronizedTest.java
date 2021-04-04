package com.qiandao.java.thread;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/28 11:18
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        new SynchronizedTest().init();
    }

    private void init() {
        final Outputer output = new Outputer();
        //线程1打印"hello,i am thread 1"
        new Thread(new Runnable() {
            @Override
            public void run() {
                output.output4("hello,i am thread 1");
            }
        }).start();

        //线程2打印"hello,i am thread 2"
        new Thread(new Runnable() {
            @Override
            public void run() {
                output.output2("hello,i am thread 2");
            }
        }).start();
    }

    static class Outputer {
        public synchronized void output(String name) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }

        public void output2(String name) {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name);
                }
            }
        }

        public void output3(String name) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }

        public static synchronized void output4(String name) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }

        public void output5(String name) {
            synchronized (Outputer.class) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name);
                }
            }
        }
    }
}