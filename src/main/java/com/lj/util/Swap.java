package com.lj.util;

/**
 * Project Name:sort
 * File Name:Swap
 * Package Name:com.lj.util
 * Date:2019/4/29
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class Swap {

    public static void swap(int[] a, int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
