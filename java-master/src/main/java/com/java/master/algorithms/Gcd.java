package com.java.master.algorithms;

/**
 * @author wangqing
 */

public class Gcd {

    /**
     * 求两个数的最大公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(3, 14));
        System.out.println(5 % 5);
        System.out.println(Integer.MAX_VALUE);
        System.out.println();
//        2147483647                              十进制
//        0000 0000 0000 0000 0000 0000 0000 0000
//        0111 1111 1111 1111 1111 1111 1111 1111 二进制
//        0x 7 f    f    f    f    f    f    f    十六进制
        System.out.println(1 + 2 + 4 + 8);
    }

}
