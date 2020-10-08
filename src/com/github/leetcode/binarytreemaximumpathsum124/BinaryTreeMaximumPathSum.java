package com.github.leetcode.binarytreemaximumpathsum124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int sum = leftGain + rightGain + root.val;

        if (sum > maxSum) {
            maxSum = sum;
        }

        return Math.max(leftGain, rightGain) + root.val;
    }
}
