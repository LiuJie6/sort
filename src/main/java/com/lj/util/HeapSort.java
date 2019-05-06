package com.lj.util;

/**
 * Project Name:sort
 * File Name:HeapSort
 * Package Name:com.lj.util
 * Date:2019/4/30
 * Author:liujie
 * Description:堆排序 时间复杂度O(NlogN) 空间复杂度O(1)  不稳定（最直观的就是当最后两个值相同且较大，同时前者为某个节点的右子节点
 * 后者为另一节点的左子节点时，后者会被交换到前者前面）
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class HeapSort {

    /**
     * 初始化大根堆
     *
     * @param a 待排序数组
     * @return 构建后的大根堆
     */
    private static int[] buildHeap(int[] a) {
        //从最后一个节点a.length-1的父节点(a.length-1-1)/2开始，直到根节点0，反复调整堆
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            adjustHeap(a, i, a.length);
        }
        return a;
    }

    /**
     * 将元素a[k]自下往上逐步调整行成大根堆
     *
     * @param a      待排序数组
     * @param k      比较位置
     * @param length 数组长度
     */
    private static void adjustHeap(int[] a, int k, int length) {
        int temp = a[k];
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {  //i为初始化节点k的左孩子，沿值较大的孩子节点向下调整
            if (i < length && i + 1 < length && a[i] < a[i + 1]) {
                i++;    //如果右孩子 > 左孩子，取右孩子下标(如果有右孩子的话（i + 1 < length）)
            }
            if (temp > a[i]) {
                break;    //如果父节点 > 孩子节点中的大值，满足大根堆，调整结束
            } else {   //父节点 < 孩子节点中的大值
                a[k] = a[i];  // 将孩子节点中的大值调整到父节点上
                k = i;   //【关键】修改k值，以便继续向下调整
            }
        }
        a[k] = temp;    //被调整的值放入最终位置
    }

    public static void heapSort(int[] a) {
        a = buildHeap(a);  //首先构建大根堆，a[0]为第一趟排序后的最大值
        for (int i = a.length - 1; i >= 0; i--) {
            Swap.swap(a, 0, i);   //堆顶元素与堆低元素交换位置，当前最大元素就在正确的位置了
            adjustHeap(a, 0, i);   //将剩余的元素整理成大根堆
        }
    }

    public static void main(String[] args) {
        int[] a = {100, 5, 8, 20, 4, 26, 35, 16, 66, 36};
        heapSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
