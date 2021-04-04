package com.qiandao.sorts.old;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/26 11:58
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int tail = arr.length - 1; tail > 0; tail--) {
            swap(arr, 0, tail);
            heapify(arr, 0, tail);   // 此时 tail 恰好是剩余堆的 size
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int parent, int size) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int maxIndex = parent;
        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != parent) {
            swap(arr, parent, maxIndex);
            heapify(arr, maxIndex, size);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] list = {0, 2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        heapSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

    }
}
