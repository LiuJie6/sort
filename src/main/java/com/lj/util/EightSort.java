package com.lj.util;

/**
 * Project Name:sort
 * File Name:EightSort
 * Package Name:com.lj.util
 * Date:2019/4/29
 * Author:liujie
 * Description:八大排序算法
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class EightSort {

    /**
     * 冒泡排序(升序)
     * 最好情况：本身就是升序的，此时比较次数为n^2,交换次数为0
     * 最坏情况：本身是降序的，此时比较次数为n^2，交换次数为n^2
     * 时间复杂度：O(n^2)    空间复杂度：O(1)    稳定排序
     *
     * @param a 要排序的数组
     */
    public static void bubbleSort(int[] a) {
        if (a.length > 0) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length - 1 - i; j++) {
                    if (a[j] > a[j + 1]) {
                        Swap.swap(a, j, j + 1);
                    }
                }
            }
        }
    }

    /**
     * 选择排序（升序）
     * 比较次数为n^2,交换次数为n
     * 时间复杂度为O(N^2)     空间复杂度为O(N)   不稳定
     * 如 5,3,5,2,9  第一次排序后，2个5 的相对位置变了
     *
     * @param a 要排序的数组
     */
    public static void selectSort(int[] a) {
        if (a.length > 0) {
            for (int i = 0; i < a.length; i++) {
                int k = i;   //选定初始值
                for (int j = i; j < a.length; j++) {   //在余下的数据里面选出最小值
                    if (a[j] < a[k]) {
                        k = j;
                    }
                }
                Swap.swap(a, i, k);
            }
        }
    }

    /**
     * 插入排序（升序）
     * 右边的无序数组向左边的有序数组插入，依次由右向左比较有序数组，
     * 当待插入a[j]的数据小于比较值时，该比较值向后挪动（【0到j-1是有序的】
     * a[j] = a[j-1], 即a[j-1向后挪动一位]，此时【0到j-1中空出了一位】）
     * 直到待插入的值大于有序数组中的一位或j=0（已经到了有序数组的头部），插入值
     * 最好情况：本身是升序，此时比较次数为N^2,交换次数为0
     * 最坏情况：本身是降序，此时比较次数为N^2，交换次数为N^2/2
     * 时间复杂度：O(N^2) 空间复杂度：O(1)   稳定排序
     *
     * @param a 待排序的数组
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }

    /**
     * 快速排序（升序）
     * 时间复杂度：O(NlogN)  空间复杂度：O(logN)    不稳定排序
     *
     * @param a 待排序数组
     */
    public static void quickSort(int[] a) {
        if (a.length > 0) {
            doQuickSort(a, 0, a.length - 1);
        }
    }

    /**
     * 递归执行快速排序
     *
     * @param a    待排序数组
     * @param low  数组起点
     * @param high 数组终点
     */
    private static void doQuickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        if (a.length > 0) {
            int middle = getMiddle(a, low, high);
            doQuickSort(a, low, middle - 1);
            doQuickSort(a, middle + 1, high);
        }
    }

    /**
     * 获取中间值所在位置
     *
     * @param a    待排序数组
     * @param low  数组起点
     * @param high 数组终点
     * @return 中间值所在位置
     */
    private static int getMiddle(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] > key) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    /**
     * 归并排序（升序）
     *时间复杂度：O(logN)  空间复杂度：O(N)   稳定排序
     * @param a 待排序数组
     */
    public static void mergeSort(int[] a) {
        if (a.length > 0) {
            doMergeSort(a, 0, a.length - 1);
        }
    }

    /**
     * 执行归并排序
     *
     * @param a     待排序数组
     * @param start 数组起点
     * @param end   数组终点
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
     * 对两个子数组进行合并
     *
     * @param a      待排序数组
     * @param left   数组起点
     * @param middle 数组中点
     * @param right  数组终点
     */
    private static void merge(int[] a, int left, int middle, int right) {
        System.out.println(left + " " + middle + " " + right);
        int[] temp = new int[a.length];    //辅助数组
        int p1 = left;
        int p2 = middle + 1;
        int k = left;   //p1.p2是检测指针，k是存放指针
        while (p1 <= middle && p2 <= right) {
            if (a[p1] < a[p2]) {   //将两者中较小的值存入辅助数组，同时对应的下标+1
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }
        while (p1 <= middle) {   //右边的数组填空了而左边的还没有
            temp[k++] = a[p1++];
        }
        while (p2 <= right) {
            temp[k++] = a[p2++];
        }
        for (int i = left; i <= right; i++) {   //将辅助数组中的数据复制给原数组
            a[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 1, 6, 8, 10, 4, 15, 2};
        //bubbleSort(a);
        //selectSort(a);
        //insertSort(a);
        //quickSort(a);
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
