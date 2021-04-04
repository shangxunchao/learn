package com.qiandao.sorts.add;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    ExecutorService executors = Executors.newSingleThreadExecutor();
    boolean t;
    @Test
    public void main() {
        HashMap <String, String> hashMap = new HashMap<>();
        hashMap.put(null,null);
        System.out.println("-------------");
        Hashtable <String, String> hashtable = new Hashtable<>();
        hashtable.put("12","null");
        ConcurrentHashMap <String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("null","null");
        System.out.println(t);
        Integer te = new Integer(1);
        Integer te2 = new Integer(1);
        System.out.println(te.equals(te2));
        StringBuffer sb = new StringBuffer();
        sb.append(1);
    }

    class TreeNode{
        private Integer value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }

}
