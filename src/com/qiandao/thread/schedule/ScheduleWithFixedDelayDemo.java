/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.thread.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/18 19:30
 **/
public class ScheduleWithFixedDelayDemo {
	static Log log = LogFactory.getLog(ScheduleWithFixedDelayDemo.class);
	private static final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

	public static void main(String[] args) {
		scheduleWithFixedDelay();
	}

	private static void scheduleWithFixedDelay() {
		log.info("scheduleWithFixedDelay----first load");
		DynamicConfLoader loader = new DynamicConfLoader();
		loader.run();
		schedule.scheduleWithFixedDelay(loader, 10, 5, TimeUnit.SECONDS);
		log.info("配置中心JAVA客户端----开启轮询监听");
	}
}