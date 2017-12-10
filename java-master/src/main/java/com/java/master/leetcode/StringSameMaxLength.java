package com.java.master.leetcode;

/**
 * Created by wangqing on 17/12/9.
 *
 * 输入两个字符串a和b，输出最长公共字串的长度
 * eg：a="abcd",b="cbce" result=2
 */

public class StringSameMaxLength {

    /**
     * 剪切字符并比较长度
     */
    private static int searchSameStrLength(String first, String second) {
        int max = 0;
        int length = first.length();
        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k <= length; k++) {
                String part = first.substring(i, k);
                if (second.contains(part)) {
                    if (part.length() > max) {
                        max = part.length();
                    }
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String first = "abcdefg";
        String second = "cbcde";
        System.out.println(searchSameStrLength(first, second));
    }

}
