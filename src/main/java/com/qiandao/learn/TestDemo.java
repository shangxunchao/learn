/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn;

import com.alibaba.fastjson.JSON;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/23 14:03
 **/
public class TestDemo implements D1 {

    @Override
    public synchronized void d21() {

        Integer m1 = 128;
        Integer m2 = 128;
    }

    @Override
    public void d31() {

    }

    public static void main(String[] args) {
        Integer m1 = 128;
        Integer m2 = 128;
        Object ob = new TestDemo();
        ob.hashCode();
        Object ob2 = ob;
        TestDemo demo = new TestDemo();
        System.out.println(ob.hashCode());
        System.out.println(demo.hashCode());
        System.out.println(ob2.hashCode());
        System.out.println(ob);
        System.out.println(ob.equals(demo));
        System.out.println(Integer.toHexString(123456));
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
        //scheduledThreadPool.schedule(() -> System.out.println("延迟1秒执行"), 1, TimeUnit.SECONDS);
        testDemo();
    }

    private static void testDemo() {
        String sql = "select *from testtb";
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //加载数据库驱动（需要下载）
            Class.forName("com.mysql.jdbc.Driver");
            //数据库链接
            String url = "jdbc:mysql://localhost:3306/study_plan?serverTimezone=UTC";
            //数据库用户名
            String user = "root";
            //数据库密码
            String password = "123456";
            //建立连接
            Connection connection = DriverManager.getConnection(url, user, password);
            //将sql语句发送到数据库
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //循环读取返回值，存入list
            String[] strs = {"id", "name", "age", "asd"};
            while (resultSet.next()) {
                Map<String, Object> result = new HashMap<>();
                for (String str : strs) {

                    result.put(str, resultSet.getObject(str));
                }

                list.add(result);
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(list));
    }
}