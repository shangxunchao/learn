package com.qiandao.sorts;

import com.alibaba.fastjson.JSON;
import com.qiandao.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ma implements Callable<Integer> {
    Lock lock = new ReentrantLock();
    private int test1 = 1;
    public static Integer [] retainAll(int arr1[], int arr2[]) {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return null;
        }
        ArrayList <Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        boolean hasEquals = false;
        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                if (hasEquals) {
                    break;
                }
                j ++;
            } else if (arr1[i] < arr2[j]){
                if (hasEquals) {
                    break;
                }
                i ++;
            } else {
                result.add(arr1[i]);
                hasEquals = true;
                i++;
                j++;
            }
        }
        return  result.toArray(new Integer[0]);
    }

    public static void main(String[] args) throws InterruptedException {

        Integer sy1 = 1;
        Integer sy2 = 2;
        Thread t1 = new Thread(()->{
            synchronized (sy1) {
                try {
                    System.out.println("t1 start");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (sy2) {
                    System.out.println("end t1");
                }
            }
        });
        /*Thread t1 = new Thread(()->{
            while (true) {
                System.out.println("../.");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
        t1.start();
        Thread t2 = new Thread(()->{
            synchronized (sy2) {
                try {
                    System.out.println("t2 start");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (sy1) {
                    System.out.println("end t2");
                }
            }
        });
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        t1.stop();
        System.out.println(t1.isInterrupted());
    }

    @Test
    public void demo () {
        Integer t1 = Integer.valueOf(127);
        Integer t2 = Integer.valueOf(127);
        System.out.println(t1 == t2);
        Student student = new Student();
        System.out.println(student.getClass());
        student.setName("1");
        System.out.println(JSON.toJSONString(student));
        List<Integer> list = new ArrayList<>();
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
        map.put("", 1);
        getDiffer(list, 2);
    }

    public void getDiffer(List<Integer> list, Integer i) {
        try {
            i = 1/0;
        }catch (Throwable throwable) {
            System.out.println("erroe  " + throwable);
        }

    }

    @Override
    public Integer call() throws Exception {
        return null;
    }

  /*  public static void main(String[] args) {
        ma mc = new ma();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }*/

    static class  ad{
        int te;
        public void pr(){
            ma m = new ma();
            System.out.println(m.test1);
        }
    }

}
