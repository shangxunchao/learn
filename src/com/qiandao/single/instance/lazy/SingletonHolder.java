package com.qiandao.single.instance.lazy;

/**
 * @Author: shangxunchao
 * @Description:Holder方式完全借助了类加载的特点
 * @Date: Created in 2019/9/19 11:30
 */

/**
 * 在单例类中并没有instance的静态成员，而是将其放到了静态内部类Holder之中，
 * 因此单例类在初始化的过程中并不会创建SingletonHolder的实例，
 * 内部类Holder中定义了SingletonHolder的静态变量，并且直接进行了实例化，
 * 只有当Holder被主动引用的时候才会创建SingletonHolder的实例
 */

/**
 *SingletonHolder实例的创建过程在Java程序编译时期收集至<clinit>()方法中，
 * 该方法又是同步方法，可以保证内存的可见性、JVM指令的顺序性和原子性。
 * Holder方式的单例模式设计是最好的设计之一，也是目前使用比较广的设计。
 */

//不允许被继承
public final class SingletonHolder {
	//实例变量
	private byte[] data = new byte[1024];

	private SingletonHolder() {

	}

	//在静态内部类中持有单例类的实例，并且可直接被初始化
	private static class Holder {
		private static SingletonHolder instance = new SingletonHolder();
	}

	//调用getInstance方法，事实上是获得Holder的instance静态属性
	public static SingletonHolder getInstance() {
		return Holder.instance;
	}
}
