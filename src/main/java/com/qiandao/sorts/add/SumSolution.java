package com.qiandao.sorts.add;

public class SumSolution {

    /**
     * 求1-n的和
     * @param n
     * @return
     */
    int Sum_Solution(int n) {
        if (n == 1) {
            return n;
        }
        return n + Sum_Solution(n-1);
    }

    /**
     * 要求不能使用乘除法、for、while、if、else、switch、
     * case等关键字及条件判断语句求1-n的和
     * @param n
     * @return
     */
    public int Sum_Solution2(int n) {
        int sum = n;
        boolean temp = n > 0 && (sum += Sum_Solution2(n - 1)) > 0;
        return sum;
    }

    /**
     * 不用加号计算两数之和
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        int result, ans;
        do {
            // 每一位相加
            result = num1 ^ num2;
            // 进位
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);
        return result;
    }

}
