package com.qiandao.sorts;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/25 17:44
 */
public class InsertSort {

	public static void insertSort(int [] a){
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && a[j] < a[j-1];j--) {
				//将未排序的第一个数据插入已排序的数据汇中的合适位置
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int [] list = {0,2,3,2,5,6,1,-2,3,14,12};
		insertSort(list);
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
	}
}
