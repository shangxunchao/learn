package com.qiandao.sorts.add;

/**
 * 两个大数相加
 */
public class TwoBigNubmerAdd {
    public static void main(String[] args) {
        add("12", "3");
    }
    public static void add (String number1, String number2) {
        int [] number1Value = new int [number1.length()];
        int [] number2Value = new int [number2.length()];
        int number1Length = number1.length();
        int number2Length = number2.length();
        int count = 0;
        for (int i = number1Length - 1; i >= 0; i--) {
            number1Value[count ++] = Integer.valueOf(String.valueOf(number1.charAt(i)));
        }
        count = 0;
        for (int i = number2Length - 1; i >= 0; i--) {
            number2Value[count ++] = Integer.valueOf(String.valueOf(number2.charAt(i)));
        }
        count = 0;
        int [] sumValue = new int [number2.length() > number1.length() ? number2Length + 1 : number1Length + 1];
        //用carry记录进位值
        int carry = 0;
        int i = 0, j = 0;
        while (i < number1Length || j < number2Length) {
            int sum1 = i < number1Length ? number1Value[i] : 0;
            int sum2 = j < number2Length ? number2Value[j] : 0;
            int sum3 = sum1 + sum2 + carry;
            sumValue[count ++] = sum3 % 10;
            carry = sum3 / 10;
            i ++;
            j ++;
        }
        //保存最后一次进位值
        sumValue[count] = carry;
        //如果最后一次进位值为0则舍去
        int endValid = carry == 0 ? sumValue.length - 2 : sumValue.length - 1;
        StringBuffer sb = new StringBuffer();
        //将所得结果拼接
        for (int a1 = endValid; a1 >= 0; a1--) {
            sb.append(sumValue[a1]);
        }
        System.out.println(sb);
    }
}
