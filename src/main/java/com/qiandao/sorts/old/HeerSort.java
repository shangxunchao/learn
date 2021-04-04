package com.qiandao.sorts.old;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/25 19:22
 */
public class HeerSort {

    //希尔排序
    private static void heerSort(int[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] < a[j-h]; j -= h) {
                    int tmp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = tmp;
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int [] list = {0,2,3,2,5,6,1,-2,3,14,12};
        heerSort(list);
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
    }
}