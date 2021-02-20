/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.sorts2;

import com.qiandao.util.log.LogUtil;

import java.util.Arrays;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/20 15:52
 **/
public class BinarySearch {
	/**
	 * 循环实现
	 * 二分查找法(折半查找法)：查找数组中是否包含指定元素。
	 * 前提：数组中的元素必须是有序的。
	 * Arrays.sort(a);：对a数组进行升序排序。
	 * Arrays.binarySearch(a,b);：使用二分法查找a数组中是否包含b这个元素。
	 *
	 * @param arr 被查找的数组
	 * @param key 指定元素
	 * @return 如果包含指定元素，则返回指定元素的index（从0开始）；如果不包含指定元素，则返回-1；
	 */
	public static int binarySearch(int[] arr, int key) {
		int min = 0;
		int max = arr.length - 1;

		while (min <= max) {
			int mid = (min + max) >> 1;//(min + max)/2

			if (arr[mid] > key) {
				max = mid - 1;
			} else if (arr[mid] < key) {
				min = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	/**
	 * 递归实现
	 * 二分查找法(折半查找法)：查找数组中是否包含指定元素。
	 * 前提：数组中的元素必须是有序的。
	 * Arrays.sort(a);：对a数组进行升序排序。
	 * Arrays.binarySearch(a,b);：使用二分法查找a数组中是否包含b这个元素。
	 *
	 * @param arr 被查找的数组
	 * @param key 指定元素
	 * @return 如果包含指定元素，则返回指定元素的index（从0开始）；如果不包含指定元素，则返回-1；
	 */
	public static int binarySearch(int[] arr, int key, int startIndex, int endIndex) {
		if (startIndex > endIndex || startIndex < 0 || endIndex > arr.length - 1) {
			return -1;
		}

		int midIndex = (startIndex + endIndex) >> 1;//(startIndex + endIndex)/2

		if (arr[midIndex] > key) {
			return binarySearch(arr, key, startIndex, midIndex - 1);
		} else if (arr[midIndex] < key) {
			return binarySearch(arr, key, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

	public static void main(String[] args) {
		//验证自定义的二分查找法
		int[] a = {};
		int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] c = {1, 4, 6, 7, 8, 3, -2};

		//循环实现
		int circulate1 = binarySearch(a, 0);
		int circulate2 = binarySearch(b, 5);
		int circulate3 = binarySearch(c, -2);
		Arrays.sort(c);
		int circulate4 = binarySearch(c, -2);
		LogUtil.e("++++++++++++++++", circulate1 + "");  //-1
		LogUtil.e("++++++++++++++++", circulate2 + ""); //4
		LogUtil.e("++++++++++++++++", circulate3 + ""); //-1
		LogUtil.e("++++++++++++++++", circulate4 + ""); //0

		//递归实现
		int recursion1 = binarySearch(a, 0, 0, a.length - 1);
		int recursion2 = binarySearch(b, 5, 0, b.length - 1);
		int recursion3 = binarySearch(c, -2, 0, c.length - 1);
		LogUtil.e("++++++++++++++++", recursion1 + "");  //-1
		LogUtil.e("++++++++++++++++", recursion2 + ""); //4
		LogUtil.e("++++++++++++++++", recursion3 + ""); //0
	}
}