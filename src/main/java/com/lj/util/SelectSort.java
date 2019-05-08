package com.lj.util;

/**
 * Project Name:sort
 * File Name:SelectSort
 * Package Name:com.lj.util
 * Date:2019/5/8
 * Author:liujie
 * Description:选择排序   时间复杂度：O(n^2)   空间复杂度：O(1)   不稳定
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class SelectSort {

    /**
     * 选择排序（升序）
     *
     * @param a 待排序的数组
     */
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {   //从0位开始，选出最小的值放在正确的位置
            int k = i;
            int temp = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {
                    k = j;
                    temp = a[j];  //将较小值赋值给temp便于下一次比较
                }
            }
            if (i != k) {
                Swap.swap(a, i, k);    //将当前的最小值放到对应的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {113, 25, 3, 36, 48, 59, 20, 3};
        selectSort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
