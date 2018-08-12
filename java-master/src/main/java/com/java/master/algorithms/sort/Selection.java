package com.java.master.algorithms.sort;

import java.util.Arrays;

/**
 * @author wangqing
 */

public class Selection {

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 4, 5, 8, 6, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (array[i] >= array[j]) {
                    array[i] = array[j];
                    index = j;
                }
            }
            exchange(i, index, array);
        }
    }


    private static void exchange(int before, int after, int[] array) {
        int old = array[before];
        array[before] = array[after];
        array[after] = old;
    }

}
