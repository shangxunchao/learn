package com.qiandao.single.instance.hungry;

/**
 * @Author: shangxunchao
 * @Description:饿汉模式
 * @Date: Created in 2019/9/19 11:15
 */

//final不允许被继承
public final class SingleTonEhangshi {
    //实例变量
    private byte[] data = new byte[1024];

    //在定义实例对象时直接初始化
    private static SingleTonEhangshi instance = new SingleTonEhangshi();

    //私有化构造函数，不允许外部NEW
    private SingleTonEhangshi() {

    }

    public static SingleTonEhangshi getInstance() {
        return instance;
    }
}