/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.thread.schedule;

import com.alibaba.fastjson.JSON;
import com.qiandao.model.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.TimeUnit;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/18 19:35
 **/
public class DynamicConfLoader implements Runnable {
    static Log log = LogFactory.getLog(DynamicConfLoader.class);

    @Override
    public void run() {
        log.info("start,threadName=" + Thread.currentThread().getName());
        try {
            if (ConfigPool.isNull()) {
                Student student = new Student();
                student.setName("DynamicConfLoader,start.");
                student.setId(1L);
                student.setAge(12);
                ConfigPool.update("DynamicConfLoader", student);
                log.info("update,threadName=" + Thread.currentThread().getName() + "ConfigPool=" + JSON.toJSONString(ConfigPool.get("DynamicConfLoader")));
                TimeUnit.SECONDS.sleep(3);
            } else {
                log.info("not update,threadName=" + Thread.currentThread().getName() + "ConfigPool=" + JSON.toJSONString(ConfigPool.get("DynamicConfLoader")));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("error,threadName=" + Thread.currentThread().getName(), e);
        }
        log.info("end,threadName=" + Thread.currentThread().getName());
    }
}