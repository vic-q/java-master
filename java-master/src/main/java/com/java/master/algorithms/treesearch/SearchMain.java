package com.java.master.algorithms.treesearch;

import java.util.Stack;

/**
 * @author wangqing
 */
public class SearchMain {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(99);
        TreeNode left = new TreeNode(77, new TreeNode(66), new TreeNode(78));
        TreeNode right = new TreeNode(101, new TreeNode(75), new TreeNode(111));
        root.setLeft(left);
        root.setRight(right);
        System.out.println(search(root, 78));
    }

    private static TreeNode search(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        TreeNode result = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.getData() == value) {
                    return node;
                } else {
                    if (result != null && result.getData() < node.getData()) {
                        result = node;
                    }
                }
                // 后进先出
                stack.push(node.getRight());
                stack.push(node.getLeft());
            }
        }
        return result;
    }

}
