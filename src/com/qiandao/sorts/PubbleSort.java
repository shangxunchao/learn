package com.qiandao.sorts;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/25 18:07
 */
public class PubbleSort {

	//冒泡
	private static void pubbleSort(int[] a) {
		int temp;//记录临时变量
		int size = a.length;//数组大小
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = 0; j < size - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int [] list = {0,2,3,2,5,6,1,-2,3,14,12};
		pubbleSort(list);
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
	}
}
