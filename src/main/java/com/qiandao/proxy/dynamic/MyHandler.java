package com.qiandao.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 必须实现该接口，完成代理类要做的事（完成目标方法 +目标方法增强）
 */
public class MyHandler implements InvocationHandler {

    private Object target;

    /**
     * 动态代理：目标对象是动态的，不是固定的，需要传入进来
     * 传入的是那个，就给那个做代理
     * @param target
     */
    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行目标方法
        Object result = method.invoke(target, args);
        //方法增强
        if (Objects.isNull(result)) {
            return new Object();
        }
        return result;
    }
}
