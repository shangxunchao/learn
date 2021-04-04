package com.qiandao.sorts.add;

public class FindGreatSum {

    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
     * 求所有子数组的和的最大值。
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1] > 0 ? array[i - 1] : 0;
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
