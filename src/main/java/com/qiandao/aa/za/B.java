package com.qiandao.aa.za;

import org.junit.Test;

public class B extends A{
    @Test
    public void main() {
        B b = (B) new A();
        b.aVoid();
        //b.bVoid();
        A a = new B();
        a.aVoid();
    }

    @Override
    public void aVoid() {
        super.aVoid();
    }

    /* public void bVoid () {
        System.out.println("bVoid");
    }*/
}
