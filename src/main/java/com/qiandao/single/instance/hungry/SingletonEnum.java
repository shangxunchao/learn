package com.qiandao.single.instance.hungry;

/**
 * @Author: shangxunchao
 * @Description:枚举方式
 * @Date: Created in 2019/9/19 11:33
 */

/**
 * 枚举方式在很多开源框架中也应用得比较广泛，枚举类型不允许被继承，
 * 同样是线程安全的，并且只能被实例化一次，但是枚举类型不能够实现懒加载
 * <p>
 * INSTANCE最后会被编译器处理成static final的，并且在static模块中进行的初始化，
 * 因此它的实例化是在class被加载阶段完成，是线程安全的。这个特性也决定了枚举单例不是lazy的，
 * 如果你的单例初始化比较费时且大多数情况下只会被引用但是不会被真正调用的话，你需要使用lazy的单例模式
 */

public class SingletonEnum {
    //实例变量
    private byte[] data = new byte[1024];

    private SingletonEnum() {

    }

    //使用枚举充当Holder
    private enum EnumHolder {
        INSTANCE;
        private SingletonEnum instance;

        EnumHolder() {
            this.instance = new SingletonEnum();
        }

        private SingletonEnum getInstance() {
            return instance;
        }
    }

    public static SingletonEnum getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }
}