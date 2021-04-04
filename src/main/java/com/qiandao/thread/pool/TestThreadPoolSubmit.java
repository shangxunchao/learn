package com.qiandao.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolSubmit {

    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newSingleThreadExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable线程处理开始...");
                int a = 0;
                int b = 3;
                //System.out.println("除以0的结果为：" + b/a);
                System.out.println("Runnable线程处理结束...");
            }
        };
        Future future = es.submit(runnable);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("task end ..." + future.get());
        es.shutdown();
    }
}
