package com.lj.util;

/**
 * Project Name:sort
 * File Name:QuickSort
 * Package Name:com.lj.util
 * Date:2019/5/8
 * Author:liujie
 * Description:快速排序  时间复杂度：O(nlogn)   空间复杂度O(nlogn)---主要是递归需要辅助空间
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */
public class QuickSort {

    public static void quickSort(int[] a) {
        if (a.length > 0) {
            sort(a, 0, a.length - 1);
        }
    }

    private static void sort(int[] a, int left, int right) {
        if (left < right) {
            int middle = getMiddle(a, left, right);
            sort(a, left, middle - 1);
            sort(a, middle + 1, right);
        }
    }

    private static int getMiddle(int[] a, int left, int right) {
        int temp = a[left];    //左值作为基准值
        while (left < right) {
            while (left < right && a[right] > temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] a = {113, 35, 66, 46, 3, 25, 3, 19};
        quickSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
