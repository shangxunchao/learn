package com.qiandao.sorts.old;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/26 11:40
 */
public class Quick {

    //Main 方法执行入口
    public static void main(String[] args) {
        //int[] list ={3,5,1,4,6,2};
        int[] list = {0, 2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    /**
     * 快速排序,递归排序：选取第一个索引的值为标记值最后放到中间位置
     *
     * @param a    数组——待排序队列
     * @param low  —— 开始位置
     * @param high —— 结束位置
     */
    public static void quickSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int temp = a[start];//标记值

        while (start < end) {
            //通行条件：while()中的值为停止循环条件，即标记值更小就停止循环
            while (start < end && temp <= a[end]) {
                end--;
            }
            //再次确认标记值是否大于后面的值
            if (temp > a[end]) {
                a[start] = a[end];
                a[end] = temp;
            }

            while (start < end && temp >= a[start]) {//标记值更大就停止循环
                start++;
            }
            if (temp < a[start]) {
                a[end] = a[start];
                a[start] = temp;
            }
        }
        //当start >= end 时将跳出循环
        //此时temp值一定会在数组的中间 即(a =2,1,3,4,6,5,)， 左边比3小，右边比3大

        if (start - 1 > low) {
            quickSort(a, low, start - 1);
        }

        if (end + 1 < high) {
            quickSort(a, end + 1, high);
        }
    }
}
