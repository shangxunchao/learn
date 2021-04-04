package com.qiandao.proxy.target;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            HelloService helloService = new HelloServiceImpl();
            Method method = HelloService.class.getMethod("sayHello", String.class);
            Object object = method.invoke(helloService, "杨文慧");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
