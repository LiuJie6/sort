package com.lj.util;

/**
 * Project Name:sort
 * File Name:RadixSort
 * Package Name:com.lj.util
 * Date:2019/5/5
 * Author:liujie
 * Description:基数排序（又称桶排序）  时间复杂度：O()
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class RadixSort {

    /**
     * 基数排序
     *
     * @param a 待排序数组
     * @param d 数组中最大值的位数
     */
    public static void radixSort(int[] a, int d) {
        int n = 1;   //位数（1：个位，10：十位，100：百位，...）
        int k = 0;   //保存结果作为下一次排序的输入
        int length = a.length;
        int[][] bucket = new int[10][length];   //桶排序用于保存没一次排序的结果，在这一位上相同的元素放在同一个桶里
        int[] order = new int[10];   //0-9,桶的每一列（相当于每一个桶），保存这一位上相同的元素
        while (n < d) {
            for (int num : a) {
                int digit = (num / n) % 10;   //取该元素在该位上的值
                bucket[digit][order[digit]] = num;  //放入对应的桶中
                order[digit]++;   //该桶保存的元素数量+1
            }
            for (int i = 0; i < 10; i++) {  //遍历每一个桶，将上一个循环保存到桶里的数据覆盖掉原数组
                if (order[i] != 0) {   //该桶里有数据，从上到下遍历这个桶并填入原数组
                    for (int j = 0; j < order[i]; j++) {
                        a[k] = bucket[i][j];
                        k++;
                    }
                    order[i] = 0; //将该桶的计数置为0，以便下一次排序
                }
            }
            n = n * 10;  //位数增加一位
            k = 0;   //数组再次从0开始填充
        }
    }

    public static void main(String[] args) {
        int[] a = {311, 11, 111, 24, 31, 47, 1, 36, 66, 1};
        radixSort(a, 1000);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
