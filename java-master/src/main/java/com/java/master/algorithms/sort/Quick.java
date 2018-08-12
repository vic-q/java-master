package com.java.master.algorithms.sort;

import java.util.Arrays;

/**
 * @author wangqing
 */

public class Quick {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(partition(array, 0, 7));
        System.out.println(Arrays.toString(array));
    }

    private static int partition(int[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = array[lo];
        while (true) {
            while (less(array[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, --j)) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
            exec(array, i, j);
        }
        exec(array, lo, j);
        return j;
    }

    private static boolean less(int first, int second) {
        return first > second;
    }

    private static void exec(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
