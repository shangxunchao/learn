package com.qiandao.sorts;

import java.util.ArrayList;

public class ContinuousPositiveSequence {

    /**
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3) {
            return res;
        }
        int left = 1,right = 2;
        int sumV = left + right;

        while(right < sum){
            if(sumV < sum){
                right ++;
                sumV += right;
            }else if(sumV > sum){
                sumV -= left;
                left++;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = left; i <= right; i++)
                {
                    list.add(i);
                }
                res.add(list);
                right++;
                sumV += right;
            }
        }
        return res;
    }
}
