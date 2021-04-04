package com.qiandao.single.instance.lazy;

/**
 * @Author: shangxunchao
 * @Description:懒汉式＋同步方法
 * @Date: Created in 2019/9/19 11:21
 */

/**
 * 采用懒汉式＋数据同步的方法既满足了懒加载又能够100%保证instance实例的唯一性。
 * 但是，
 * synchronized关键字的排它性会导致getInstance()方法同一时刻只能被一个线程访问，
 * 性能会比较低下
 */

//final不允许被继承
public final class SingleTonLhangshiSync {
    //实例变量
    private byte[] data = new byte[1024];

    //定义实例，但是不直接初始化
    private static SingleTonLhangshiSync instance = null;

    //私有化构造函数，不允许外部NEW
    private SingleTonLhangshiSync() {

    }

    //向getInstance方法加入同步控制，每次只能有一个线程能够进入
    public static synchronized SingleTonLhangshiSync getInstance() {
        if (null == instance) {
            instance = new SingleTonLhangshiSync();
        }
        return instance;
    }
}

