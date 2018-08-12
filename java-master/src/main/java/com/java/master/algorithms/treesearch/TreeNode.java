package com.java.master.algorithms.treesearch;

import com.google.common.base.MoreObjects;

/**
 * @author wangqing
 */
public class TreeNode {

    private int data;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        if (this != null) {
            return MoreObjects.toStringHelper(this)
                    .add("data", this.data)
                    .toString();
        }
        return null;
    }
}
