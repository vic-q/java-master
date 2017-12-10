package com.java.master.leetcode;

import java.util.Arrays;

/**
 * Created by wangqing on 17/9/21.
 */

public class TwoSum1Demo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int result = 7;
        System.out.println(Arrays.toString(twoSum(array, result)));
    }

    /**
     * 输入一个数和一个数组，返回和是这个值的两个数的索引
     *
     * eg: array=[1,2,3,4],result=7
     * @param result
     * @return
     */
    public static int[] twoSum(final int[] array, final int result) {
        int a = 0, b = 0;
        for (int n = 0; n < array.length; n++) {
            int s1 = array[n];
            for (int i = n + 1; i < array.length; i++) {
                int s2 = array[i];
                int sum = s1 + s2;
                if (sum == result) {
                    a = n;
                    b = i;
                }
            }
        }
        return new int[] {a, b};
    }

}
