package com.qiandao.thread.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPool {
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
}
