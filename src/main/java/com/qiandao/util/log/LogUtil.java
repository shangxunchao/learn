/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.util.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/20 15:59
 **/
public class LogUtil {
    static final Log log = LogFactory.getLog(LogUtil.class);

    public static void e(String param1, String param2) {
        log.info(String.format("e,param1=%s,param2=%s", param1, param2));
    }

    public static void main(String[] args) {
        log.info(String.format("e,param1=%s,param2=%s", 1, 2));
    }
}