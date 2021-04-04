package com.qiandao.java.thread;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/28 11:45
 */
public class MutilThreadShareVariable {
    static volatile int count = 100;

    public static void main(String[] args) throws Exception {
        final ShareDataDec sdDec = new ShareDataDec();
        final ShareDataInc sdInc = new ShareDataInc();
        //线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    sdDec.dec();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    sdInc.inc();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    static class ShareDataDec {
        public synchronized void dec() {
            count--;
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " dec 1 from count,count remain " + count);
        }
    }

    static class ShareDataInc {
        public synchronized void inc() {
            count = count + 2;
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " inc 2 from count,count remain " + count);
        }
    }
}
