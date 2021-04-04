/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn.dynamic.proxy.cglib;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiandao.learn.proxyStatic.UserManager;
import com.qiandao.model.Student;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/10/29 15:00
 **/
public class Main {

    static class RedisTest {

        private static String[] keys = new String[1000];

        private static String randomString(int length) {
            Random random = new Random();
            char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            StringBuilder key = new StringBuilder(length);
            int i = length;
            while (i > 0) {
                key.append(chars[random.nextInt(chars.length)]);
                i--;
            }
            return key.toString();
        }

        private static void write(Jedis jedis, int length) {
            long start = System.currentTimeMillis();
            String key = null;
            String value = null;
            for (int i = 0; i < 1000; i++) {
                key = randomString(length);
                keys[i] = key;
                value = randomString(1000);
                jedis.set(key, value);
            }
            System.out.println(String.format("put key length %d with value length 1000 in 1000 tims costs: %d ms", length, System.currentTimeMillis() - start));
        }

        private static void read(Jedis jedis, int length) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < keys.length; i++) {
                jedis.get(keys[i]);
            }
            System.out.println(String.format("get key length %d with value length 1000 in 1000 tims costs: %d ms", length, System.currentTimeMillis() - start));
        }

        public static void main(String[] args) throws InterruptedException {
            Jedis jedis = new Jedis("localhost", 6379);
            int[] lengths = {10, 100, 500, 1000, 2500, 5000, 7500, 10000, 20000};
            for (int i = 0; i < lengths.length; i++) {
                write(jedis, lengths[i]);
                read(jedis, lengths[i]);
                keys = new String[1000];
                jedis.flushAll();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //获取Enhancer 对象
        Enhancer enhancer = new Enhancer();
        //设置代理类的父类（目标类）
        enhancer.setSuperclass(UserManagerImpl.class);
        //设置回调方法(拦截器)
        enhancer.setCallback(new MyMethodInterceptor());
        //获取代理对象
        UserManager proxySubject = (UserManager) enhancer.create();

        //调用目标方法
        proxySubject.addUser("1", "测试");

    }


    @Test
    public void de() {
        Student student = new Student();
        JSON.toJSONString(student);
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("", "");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("", "");
        Set<String> basePackages = new HashSet<String>() {{
            add("12");
            {
                add("34");
            }
        }};
        Lock lock = new ReentrantLock();
        lock.lock();
        String a = new String("abc");
        String b = new String("abc");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(a, 1);
        map.put(b, 2);
        System.out.println(JSON.toJSONString(map));
        System.out.println((student).equals((student)));
        System.out.println(((long) 2 * 0x7fffffff));
        try {
            Random rand = new Random();
            TimeUnit.HOURS.sleep(rand.nextInt(200) + 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo1() throws UnsupportedEncodingException {
        Map<String, Object> returnModel = (Map<String, Object>) JSONObject.parse("{\n" +
                "\t\"code\": 1\n" +
                "}");
        String ids = "[101242035,2]";
        System.out.println(JSON.toJSONString(returnModel));
        List<Long> te = JSON.parseArray(ids, Long.class);
        System.out.println(JSON.toJSONString(te));
        List<Long> smallGroupTrailCourseIds = new ArrayList<Long>() {{
            add(12L);
            add(16L);
        }};
        List<Long> list = new ArrayList<Long>() {{
            add(12L);
            add(13L);
        }};
        System.out.println("list1-- " + JSON.toJSONString(list));
        list = list.stream().filter(param -> !smallGroupTrailCourseIds.contains(param))
                .collect(Collectors.toList());
        System.out.println("list2-- " + JSON.toJSONString(list));
        System.out.println("1+1".replaceAll("\\+", "%20"));
        System.out.println("".equals(null));
        Student student = new Student();
        student.setName("12");
        System.out.println(JSON.toJSONString(student));
        Long te2 = 1L;
        System.out.println(te2.equals(1));
        Long ts = 111111111112L;
        Long ts2 = 111111111111L;
        System.out.println(Objects.equals(ts, ts2));
        Object sd = 111111;
        Object sd2 = 111111;
        System.out.println(sd.equals(sd2));

        System.out.println(URLEncoder.encode("https://www.baidu.com/?tn=62095104_23_oem_dg", "utf-8"));

        System.out.println(URLDecoder.decode(URLEncoder.encode("https://www.baidu.com/?tn=62095104_23_oem_dg", "utf-8"), "utf-8"));
        System.out.println(Student.class.getName());
    }

    @Test
    public void demo2() {
        List<Student> list = new ArrayList<Student>() {{
            Student student = new Student();
            student.setId(1L);
            student.setName("TE");
            add(student);
            Student student2 = new Student();
            student2.setId(1L);
            student2.setName("TE2");
            add(student2);
        }};
        list.stream().
                map(Student::getId).collect(Collectors.toList());
		/*list.stream().
				collect(Collectors.groupingBy(Student::getId));*/
        list.stream().
                collect(Collectors.toMap(Student::getId, feedBackStatus -> feedBackStatus));
        System.out.println(Collections.emptyList().size());
        String arguments = "TEACHER:OC:ASSEMBLER:MATERIAL_URL_KEY_LOCK:842902:1:5941511";
        System.out.println(Arrays.toString("123侧护abcA".getBytes(StandardCharsets.UTF_8)));
        //getBitSize(arguments);
        new ArrayList<String>() {{
            add("Tom");
            add("Sally");
            add("John");
        }};
    }

    private void getBitSize(String str) {
        // 得到当前的系统属性
        String encoding = System.getProperty("file.encoding");
        System.out.println("当前编码:" + encoding);
        try {
            int len = str.getBytes().length;
            System.out.println("1.按操作系统默认编码来编码:" + len);

            len = str.getBytes("GBK").length;
            System.out.println("2.GBK编码的字节数：" + len);

            len = str.getBytes(StandardCharsets.UTF_8).length;
            System.out.println("3.UTF-8编码的字节数：" + len);

            len = str.getBytes("Unicode").length;
            System.out.println("4.Unicode编码的字节数：" + len);

        } catch (java.io.UnsupportedEncodingException e) {
            System.out.println(e.getMessage().toString());
        }
    }

}