package com.lj.util;

import java.util.Arrays;

/**
 * Project Name:sort
 * File Name:MainTest
 * Package Name:com.lj.util
 * Date:2019/5/9
 * Author:liujie
 * Description:对各排序算法的测试
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class MainTest {

    /**
     * 获取数组a中最大数的位数
     *
     * @param a 数组a
     * @return 位数
     */
    private static int getMaxNumLength(int[] a) {
        if (a.length > 0) {
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (max < a[i]) {
                    max = a[i];
                }
            }
            return (max + "").length();
        }
        return 0;
    }

    /**
     * 构建用于排序的初始数组
     *
     * @return 初始数组
     */
    private static OriginData buildOriginData(int length) {
        OriginData originData = new OriginData();
        int[][] a = new int[8][length];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < length; j++) {
                a[i][j] = new Double(Math.random() * 100).intValue();
            }
        }
        originData.a = a;
        originData.length = length;
        return originData;
    }

    private static class OriginData {
        int[][] a;
        int length;
    }

    /**
     * 打印排序算法用时
     *
     * @param a          待排序数组
     * @param sortMethod 排序方法
     */
    private static void printSortTime(int[] a, String sortMethod) {
        long startTime = System.nanoTime();    //获取系统当前时间的纳秒数（只用于计算时差）
        long endTime;
        switch (sortMethod) {
            case "冒泡排序":
                BubbleSort.bubbleSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "插入排序":
                InsertSort.insertSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "选择排序":
                SelectSort.selectSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "快速排序":
                QuickSort.quickSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "归并排序":
                MergeSort.mergeSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "堆排序":
                HeapSort.heapSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "希尔排序":
                ShellSort.shellSort(a);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            case "基数排序":
                int d = getMaxNumLength(a);
                RadixSort.radixSort(a, d);
                endTime = System.nanoTime();
                System.out.println("数组大小为 "+a.length+" 时，【" + sortMethod + "】耗时:" + (endTime - startTime) / 1000000d + "ms");
                break;
            default:
                break;
        }
    }

    /**
     * 判断a数组是否有序
     *
     * @param a   数组
     * @param asc 是否升序
     * @return 判断结果
     */
    private static boolean isSort(int[] a, boolean asc) {
        if (a.length > 1) {
            if (asc) {
                for (int i = 1; i < a.length; i++) {
                    if (a[i - 1] > a[i]) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = 1; i < a.length; i++) {
                    if (a[i - 1] < a[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OriginData originData = buildOriginData(10000000);
        int[][] a = originData.a;
        //printSortTime(a[0], "冒泡排序");
        //printSortTime(a[1], "插入排序");
        //printSortTime(a[2], "选择排序");
        //printSortTime(a[3], "快速排序");
        printSortTime(a[4], "归并排序");
        printSortTime(a[5], "堆排序");
        printSortTime(a[6], "希尔排序");
        printSortTime(a[7], "基数排序");
    }
}
