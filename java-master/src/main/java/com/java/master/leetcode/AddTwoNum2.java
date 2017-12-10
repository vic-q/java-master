package com.java.master.leetcode;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangqing on 17/9/21.
 */

public class AddTwoNum2 {

    public static void main(String[] args) {
        String s1 = "2->5->3";
        String s2 = "5->6->4";
        System.out.println(addTwoNum(s1, s2));
    }

    /**
     * Input: 2->5->3, 5->6->4
     * Output: 7->1->8
     */
    public static String addTwoNum(String s1, String s2) {
        String[] array1 = s1.split("->");
        String[] array2 = s2.split("->");
        List<Integer> result = new ArrayList<Integer>();
        init(result, array1.length);
        for (int i = 0; i < array1.length; i++) {
            int a1 = Integer.parseInt(array1[i]);
            int a2 = Integer.parseInt(array2[i]);
            int sum = a1 + a2;
            if (sum >= 10) {
                Integer v1 = result.get(i);
                result.set(i, sum - 10 + v1);
                result.set(i + 1, 1);
            } else {
                Integer v1 = result.get(i);
                result.set(i, sum + v1);
            }
        }
        return Joiner.on("->").join(result);
    }

    private static void init(List<Integer> array, int length) {
        for (int n = 0; n < length; n++) {
            array.add(0);
        }
    }

}
