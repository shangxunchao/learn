package com.qiandao.aa.za;

public class C {
    public static void main (String[] args) throws InterruptedException {
        CStatic.CCStatic ccStatic = new CStatic.CCStatic();
        CStatic.CCStatic ccStatic2 = new CStatic.CCStatic();
        System.out.println(ccStatic2.getA());
        Thread thread = new Thread(() -> {
            ccStatic.setA();
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(ccStatic2.getA());
    }
}
