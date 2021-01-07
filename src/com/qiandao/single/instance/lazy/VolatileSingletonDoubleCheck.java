package com.qiandao.single.instance.lazy;

import java.net.Socket;
import java.sql.Connection;

/**
 * @Author: shangxunchao
 * @Description:Volatile+Double-Check
 * @Date: Created in 2019/9/19 11:26
 */

/**
 * 为了解决Double-Check指令重排导致的空指针问题，
 * 可以用volatile关键字防止这种重排序的发生
 */

//final不允许被继承
public final class VolatileSingletonDoubleCheck {
	//实例变量
	private byte[] data = new byte[1024];

	//定义实例，但是不直接初始化
	private static volatile VolatileSingletonDoubleCheck instance = null;

	Connection con;
	Socket socket;

	//私有化构造函数，不允许外部NEW
	private VolatileSingletonDoubleCheck() {
		this.con = con;//初始化
		this.socket = socket;//初始化

	}

	public static VolatileSingletonDoubleCheck getInstance() {
		//当instance为null时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
		if (null == instance) {
			//只有一个线程能够获得SingletonDoubleCheck.class关联的monitor
			synchronized (VolatileSingletonDoubleCheck.class) {
				//判断如果instance为null则创建
				if (null == instance) {
					instance = new VolatileSingletonDoubleCheck();
				}
			}
		}
		return instance;
	}
}
