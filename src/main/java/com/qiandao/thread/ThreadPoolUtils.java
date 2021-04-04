/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/13 16:09
 **/
public class ThreadPoolUtils {
    static Log log = LogFactory.getLog(ThreadPoolUtils.class);
    /**
     * 学习中心首页第三屏接口线程池
     */
    public static ThreadPoolExecutor homeThirdExecutor = new ThreadPoolExecutor(
            4,
            4,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new BasicThreadFactory.Builder().namingPattern("homeThird-executor-%d").uncaughtExceptionHandler(new homeThirdExceptionHandler()).build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 学习中心首页线程池异常
     */
    public static class homeThirdExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.error(String.format("homeThirdExceptionHandler error Thread info = %s", t.getName()), e);
        }
    }

    /**
     * 学习中心首页作品推荐墙线程池
     */
    public static ThreadPoolExecutor recommendWallExecutor = new ThreadPoolExecutor(
            4,
            4,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            new BasicThreadFactory.Builder().namingPattern("homeThird-executor-%d").uncaughtExceptionHandler(new RecommendWallExecutorExceptionHandler()).build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 学习中心作品推荐墙线程池异常
     */
    public static class RecommendWallExecutorExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.error(String.format("RecommendWallExecutorExceptionHandler error Thread info = %s", t.getName()), e);
        }
    }
}