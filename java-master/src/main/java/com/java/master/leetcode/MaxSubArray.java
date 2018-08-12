package com.java.master.leetcode;

/**
 * @author wangqing
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {-2, 1, 1, 4, -1, 2, 1, -5, 4};
        System.out.println("maxSum=" + maxArray(array));
    }


    public static int maxArray(int[] array) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        return maxSum;

    }
}