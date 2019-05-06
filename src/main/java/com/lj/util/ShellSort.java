package com.lj.util;

/**
 * Project Name:sort
 * File Name:ShellSort
 * Package Name:com.lj.util
 * Date:2019/4/29
 * Author:liujie
 * Description:希尔排序
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class ShellSort {

    /**
     * 希尔排序（升序）
     * 本质是插入排序（对直接插入排序的优化）
     * 时间复杂度O（N^1.3）  ,空间复杂度：O(1)   不稳定排序
     *
     * @param a 待排序数组
     */
    public static void shellSort(int[] a) {
        int n = a.length;
        int gap = n / 2;
        while (gap >= 1) {     //最外层循环，控制步长大于等于1
            for (int i = gap; i < n; i++) {         //第二层循环，对每一组进行插入排序
                int j = i;
                int temp = a[j];
                while (j >= gap && temp < a[j - gap]) {     //第三层循环，对其中一组进行插入排序
                    a[j] = a[j - gap];
                    j = j - gap;
                }
                a[j] = temp;
            }
            gap = gap / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 4, 7, 2, 8, 20, 1};
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
