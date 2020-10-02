package com.github.leetcode.flattenbinarytree114;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class FlattenBinaryTree {

    TreeNode root;
    TreeNode sentinel;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        TreeNode previous = null;

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (previous != null) {
                previous.left = null;
                previous.right = current;
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            previous = current;
        }
    }
}
