/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.learn.thread;

import com.alibaba.fastjson.JSON;
import com.qiandao.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/11/4 14:54
 **/
public class CompletableFutureDemo {
    private static ExecutorService executorService =
            new ThreadPoolExecutor(5, 6,
                    1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(100),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        demo();
        demo2();
        demo3();
    }

    private static void demo() {
        //runAsync无返回值
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello");
        }, executorService);
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("CompletableFuture");
    }

    public static String demo2() {
        //supplyAsync带返回值
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello-demo2", executorService);
        try {
            System.out.println(future.get());
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("CompletableFuture-demo2");
        return null;
    }

    public static String demo3() {
        //CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("before:" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("after:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        }, executorService);
        try {
            future.complete("World");
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void demo5() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }

    @Test
    public void demo4() {
        List<Student> students = new ArrayList<>();
        CompletableFuture<List<Student>> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("before:" + Thread.currentThread().getName());
                new D2("before", 12, 34, students);
                TimeUnit.SECONDS.sleep(5);
                new D2("after", 12, 34, students);
                System.out.println("after:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }, executorService);
        try {
            TimeUnit.SECONDS.sleep(5);
            future.complete(students);
            System.out.println(JSON.toJSONString(future.get()) + "res");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public class D2 {
        private String name;
        private Integer score;
        private Integer age;
        private List<Student> students;

        public D2(String name, Integer score, Integer age, List<Student> students) {
            this.name = name;
            this.score = score;
            this.age = age;
            this.students = students;
            Student student = new Student();
            student.setName(name);
            student.setScore(score);
            student.setAge(age);
            students.add(student);
        }
    }
}