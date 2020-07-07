package com.github.leetcode.invertbinarytree226;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode invertTreeRecursively(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTreeRecursively(root.left);

        root.left = invertTreeRecursively(root.right);
        root.right = left;

        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode tempLeft = current.left;
            current.left = current.right;
            current.right = tempLeft;

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}
