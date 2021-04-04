package com.qiandao.single.instance;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/9/19 17:31
 */
public enum Toy {

    SOLDIER {
        @Override
        public void execute() {
            System.out.println("I'm a SOLDIER.");
        }
    },
    DOLL {
        @Override
        public void execute() {
            System.out.println("I'm a doll.");
        }
    };

    private String message;

    // template method
    public abstract void execute();

}
