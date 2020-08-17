package com.github.leetcode.balancedbinarytree110;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) != -1;
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeHeight;
        int rightTreeHeight;

        if ((leftTreeHeight = treeHeight(root.left)) == -1
                || (rightTreeHeight = treeHeight(root.right)) == -1
                || Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            return -1;
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
