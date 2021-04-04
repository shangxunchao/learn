package com.qiandao.java.timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/10/31 10:32
 */
public class Main {

    static String df1 = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        try {
            System.out.println(timstamp2DateTime(1470278082000L));
            System.out.println(DateTime2timstamp("2016-08-04 10:34:42"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 毫秒级时间戳转化成日期和时间
     *
     * @param trackTime
     * @return
     */
    public static String timstamp2DateTime(Long timestamp) {
        return new SimpleDateFormat(df1).format(timestamp);
    }

    public static Long DateTime2timstamp(String dateTime) throws ParseException {
        return (new SimpleDateFormat(df1)).parse(dateTime).getTime();
    }
}
