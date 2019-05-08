package com.lj.util;

/**
 * Project Name:sort
 * File Name:InsertSort
 * Package Name:com.lj.util
 * Date:2019/5/8
 * Author:liujie
 * Description: 插入排序：  时间复杂度：O(N^2)   空间复杂度：O(1)  稳定
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class InsertSort {

    /**
     * 直接插入排序（升序）
     *
     * @param a 待排序数组
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {   //初始位0默认有序
            int temp = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > temp) {   //temp(a[i])从有序数组的右边插入
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {111, 13, 2, 15, 66, 26, 36, 3, 13};
        insertSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

}
