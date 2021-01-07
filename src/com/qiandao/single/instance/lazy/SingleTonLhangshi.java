package com.qiandao.single.instance.lazy;

/**
 * @Author: shangxunchao
 * @Description:懒汉模式
 * @Date: Created in 2019/9/19 11:16
 */

//final不允许被继承
public final class SingleTonLhangshi {
	//实例变量
	private byte[] data = new byte[1024];

	//定义实例，但是不直接初始化
	private static SingleTonLhangshi instance = null;

	//私有化构造函数，不允许外部NEW
	private SingleTonLhangshi() {

	}

	public static SingleTonLhangshi getInstance() {
		if (null == instance) {
			instance = new SingleTonLhangshi();
		}
		return instance;
	}
}
