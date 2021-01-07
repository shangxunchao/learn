package com.qiandao.single.instance.lazy;

import java.net.Socket;
import java.sql.Connection;

/**
 * @Author: shangxunchao
 * @Description:Double-Check
 * @Date: Created in 2019/9/19 11:22
 */

/**
 * 这种方式在多线程的情况下，可能会引起空指针异常，
 * 这是因为如果在如上代码的构造方法中还存在初始化其他资源的情况的话，
 * 由于JVM运行时存在指令重排的情况，这些资源在实例化时顺序并无前后关系的约束，
 * 那么在这种情况下，就极有可能是instance最先被实例化，
 * 而con和socket并未完成实例化，
 * 而未完成实例化的实例在调用其方法时将会抛出空指针异常
 */

//final不允许被继承
public final class SingletonDoubleCheck {
	//实例变量
	private byte[] data = new byte[1024];

	//定义实例，但是不直接初始化
	private static SingletonDoubleCheck instance = null;

	Connection con;
	Socket socket;

	//私有化构造函数，不允许外部NEW
	private SingletonDoubleCheck() {
		this.con = con;//初始化
		this.socket = socket;//初始化

	}
	public static SingletonDoubleCheck getInstance() {
		//当instance为null时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
		if (null == instance) {
			//只有一个线程能够获得SingletonDoubleCheck.class关联的monitor
			synchronized (SingletonDoubleCheck.class) {
				//判断如果instance为null则创建
				if (null == instance) {
					instance = new SingletonDoubleCheck();
				}
			}
		}
		return instance;
	}
}
