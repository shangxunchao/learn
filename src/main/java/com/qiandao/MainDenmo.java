package com.qiandao;

public class MainDenmo {

    public Integer FindK(int [] target, int k) {
        int start = 0;
        int end = target.length;
        sort(target,start,end);
        int[] temp = new int[1];
        return target[k];

    }

    public void sort(int [] source, int start, int end) {

        while(start<end) {
            int mild = getMild(source,  start,  end);
            sort(source,start,mild-1);
            sort(source,mild+1,end);
        }
    }

    public int getMild(int [] source, int start, int end) {

        int first = source[start];
        while (start<end) {
            while (start<end && source[end] > first) {
                end--;
            }
            int temp = source[start];
            source[start] = source[end];
            source[end]= temp ;
            while (start<end && source[start] < first) {
                start++;
            }
            temp = source[start];
            source[start] = source[end];
            source[end]= temp ;
        }
        return start;
    }
}
