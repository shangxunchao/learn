package com.qiandao.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadPoolCallableSuccess {

    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newSingleThreadExecutor();
        Callable callable = new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("线程处理开始...");
                int a = 2;
                int b = 3;
                System.out.println("3/2的结果为：" + b/a);
                System.out.println("线程处理结束...");
                return "0";
            }
        };
        Future<String> future = es.submit(callable);
        while(true) {
            //idDone:如果任务已完成，则返回 true。 可能由于正常终止、异常或取消而完成，在所有这些情况中，此方法都将返回 true。
            if(future.isDone()) {
                System.out.println("任务执行完成：" + future.get());
                break;
            }
        }
        es.shutdown();
    }
}
