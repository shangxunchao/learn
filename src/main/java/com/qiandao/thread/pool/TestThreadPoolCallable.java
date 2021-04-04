package com.qiandao.thread.pool;

import java.util.concurrent.*;

/**
 * 线程池提交任务的两种方式：execute与submit的区别
 * <href>https://www.cnblogs.com/jxxblogs/p/11882381.html</href>
 */
public class TestThreadPoolCallable {

    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newSingleThreadExecutor();
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("线程处理开始...");
                int a = 0;
                int b = 3;
                System.out.println("除以0的结果为：" + b/a);
                System.out.println("线程处理结束...");
                return "0";
            }
        };
        Future<String> future = es.submit(callable);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("task end ...");
        System.out.println("任务执行完成，结果为：" + future.get());
    }
}
