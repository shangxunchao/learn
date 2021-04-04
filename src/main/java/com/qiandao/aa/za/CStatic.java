package com.qiandao.aa.za;

public class CStatic {
    private static Integer a = 5;
    public static class CCStatic {
        public void setA(){
            a ++ ;
        }

        public Integer getA() {
            return a;
        }
    }
}
