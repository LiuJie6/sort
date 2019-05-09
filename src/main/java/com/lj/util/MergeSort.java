package com.lj.util;

/**
 * Project Name:sort
 * File Name:MergeSort
 * Package Name:com.lj.util
 * Date:2019/5/8
 * Author:liujie
 * Description:归并排序  时间复杂度：O(nlogn)   空间复杂度O(n)   稳定
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class MergeSort {

    /**
     * 对两个子数组进行合并
     *
     * @param a      待排序数组
     * @param left   左值下标
     * @param middle 中间值下标
     * @param right  右值小标
     */
    private static void merge(int[] a, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];   //辅助数组
        int p1 = left;
        int p2 = middle + 1;
        int k = 0;
        while (p1 <= middle && p2 <= right) {
            if (a[p1] < a[p2]) {
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }
        while (p1 <= middle) {
            temp[k++] = a[p1++];
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];
        }
        k = 0;
        for (int i = left; i <= right; i++) {
            a[i] = temp[k++];
        }
    }

    /**
     * 执行归并排序（递归操作）
     *
     * @param a     待排序的数组
     * @param start 开始点下标
     * @param end   结束点下标
     */
    private static void doMergeSort(int[] a, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            doMergeSort(a, start, middle);
            doMergeSort(a, middle + 1, end);
            merge(a, start, middle, end);
        }
    }

    /**
     * 归并排序（升序）
     *
     * @param a 待排序数组
     */
    public static void mergeSort(int[] a) {
        if (a.length > 0) {
            doMergeSort(a, 0, a.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {123, 346, 235, 3, 16, 66, 3, 56};
        mergeSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
