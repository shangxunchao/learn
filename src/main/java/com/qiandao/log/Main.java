package com.qiandao.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        log.info("Start process...");
        try {
            "".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Invalid encoding.", e);
        }
        log.info("Process end.");
    }
}
