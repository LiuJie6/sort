package com.lj.util;

/**
 * Project Name:sort
 * File Name:BubbleSort
 * Package Name:com.lj.util
 * Date:2019/5/8
 * Author:liujie
 * Description:冒泡排序：  时间复杂度0(N^2)  空间复杂度：O(1)  稳定
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class BubbleSort {

    /**
     * 冒泡排序（升序）
     *
     * @param a 待排序数组
     */
    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    Swap.swap(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {11, 1, 25, 3, 66, 36, 25};
        bubbleSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
