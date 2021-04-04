package com.qiandao.sorts.add;

public class MoreThanHalfNum {

    /**
     * 找出数组中,出现次数超过数组长度的一半的数字(只可能一个数字)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int win = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            //战场上没人
            if (count == 0) {
                win = array[i];
                count = 1;
            } else {
                //是一个阵营
                if (win == array[i]) {
                    count++;
                    //不同阵营
                } else {
                    count--;
                }
            }
        }
        //如果不存出现过半的数，上面的算法是错误的，需要加一个检验判断一下 win 是否出现了一般以上
        count = 0;
        for(int arr : array) {
            if(arr == win) {
                count ++;
            }
        }
        return count > array.length / 2 ? win : 0;
    }
}
