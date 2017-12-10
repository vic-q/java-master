package com.java.master.leetcode;

/**
 * Created by wangqing on 17/9/20.
 * 寻找最长重复字符串
 */

public class LongRepeatableString3 {

    public static void main(String[] args) {
        String str = "azzzzhhhhhxyzzzzzzz";

        System.out.println(test(str));

    }

    public static String test(String str) {
        int max = 0;
        int idx = 0;
        for (int n = 0; n < str.length(); n++) {
            char cn = str.charAt(n);
            int count = 1;
            for (int i = n + 1; i < str.length(); i++) {
                char ci = str.charAt(i);
                if (cn == ci) {
                    count++;
                    if (count > max) {
                        max = count;
                        idx = n;
                    }
                } else {
                    break;
                }
            }
        }
        return str.substring(idx, idx + max);
    }
}
