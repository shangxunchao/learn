package com.qiandao.proxy.dynamic;

import com.qiandao.proxy.target.HelloService;
import com.qiandao.proxy.target.HelloServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        //创建代理对象，使用proxy
        //1.创建目标类
        HelloService helloService = new HelloServiceImpl();
        //2.创建InvocationHandler
        InvocationHandler myHandler = new MyHandler(helloService);
        //3.创建代理对象
        HelloService proxyService = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(), myHandler);
        //4.通过代理执行方法
        String result = proxyService.sayHello("杨文慧");
        System.out.println("love " + result);
    }
}
