package com.java.master.algorithms;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wangqing
 */
public class LineSegment {

    public static void main(String[] args) {
        Segment one = new Segment(1, 3);
        Segment two = new Segment(1, 2);
        Segment four = new Segment(2, 6);
        Segment three = new Segment(4, 7);
        List<Segment> segments = Lists.newArrayList(one, two, four, three);
        sum(segments);
    }

    public static int sum(List<Segment> segments) {
        // 排序省略
        int sumLen = 0;
        Segment first = segments.get(0);
        Segment temp = first;
        for (int i = 1; i < segments.size(); i++) {
            Segment segment = segments.get(i);
            if (temp.contains(segment)) {
                // 包含
            } else if (temp.separation(segment)) {
                // 相离
                sumLen += temp.length();
                temp = segment;
            } else {
                // 相交
                temp = new Segment(temp.getLeft(), segment.getRight());
            }
        }
        return sumLen + temp.length();
    }

    private static class Segment {

        private int left;

        private int right;

        public Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }

        /**
         * 两条线段是否包含
         * @param segment
         * @return
         */
        public boolean contains(Segment segment) {
            return this.left <= segment.left && this.right >= segment.right;
        }

        /**
         * 两条线段是否相离
         * @param segment
         * @return
         */
        public boolean separation(Segment segment) {
            return this.right < segment.left;
        }

        public int length() {
            return this.right - this.left;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

}
