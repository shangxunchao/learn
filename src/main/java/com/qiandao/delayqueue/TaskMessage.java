package com.qiandao.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/18 10:16
 */
public class TaskMessage implements Delayed {

    private String body;  //消息内容
    private long executeTime;//执行时间
    private Function function;//执行方式

    public TaskMessage(Long delayTime, String body, Function function) {
        this.body = body;
        this.function = function;
        this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed delayed) {
        TaskMessage msg = (TaskMessage) delayed;
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - msg.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }


}