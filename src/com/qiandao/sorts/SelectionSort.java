package com.qiandao.sorts;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/25 18:14
 */
public class SelectionSort {

	public static void selectionSort(int[] arr) {

		for(int i=0; i<arr.length-1; i++) {
			//最小数的索引
			int minIndex = i;
			for(int j=i; j<arr.length; j++) {
				//找到最小数，并记录最小数的索引
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			//交换符合条件的数
			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
	}

	public static void main(String[] args) {
		int [] list = {0,2,3,2,5,6,1,-2,3,14,12};
		selectionSort(list);
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
	}
}
