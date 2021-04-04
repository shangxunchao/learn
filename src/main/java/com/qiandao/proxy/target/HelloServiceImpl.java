package com.qiandao.proxy.target;

import com.qiandao.proxy.target.HelloService;

/**
 * 目标类
 */
public class HelloServiceImpl implements HelloService {
    /**
     * 目标方法
     * @param name
     */
    @Override
    public String sayHello(String name) {
        System.out.println("HelloServiceImpl:" + name);
        return name;
    }
}
