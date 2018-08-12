package com.java.master.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqing
 */
public class Merge {

    public static void main(String[] args) {
        List<Interval> list = Lists.newArrayList(new Interval(1, 3), new Interval(3, 4), new Interval(7, 8), new Interval(6, 7));
        merge(list);
        System.out.println(list.size());
    }

    public static void merge(List<Interval> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            Interval l = array.get(0);
            Interval r = array.get(i + 1);
            if (l.connect(r)) {
                Interval theNew = new Interval(l.getLeft(), r.getRight());
                array.set(i, theNew);
                array.remove(i + 1);
                merge(array);
            }
        }
    }

    private static class Interval {
        private int left;
        private int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean connect(Interval r) {
            return this.getRight() >= r.getLeft() && this.getRight() <= r.getRight();
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

}
