package com.github.leetcode.binarytreeinordertraversal94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeInOrderTraversal {

    private final List<Integer> traversal = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return traversal;
        }

        inorderTraversal(root.left);
        traversal.add(root.val);
        inorderTraversal(root.right);

        return traversal;
    }

    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            traversal.add(root.val);
            root = root.right;
        }

        return traversal;
    }
}
