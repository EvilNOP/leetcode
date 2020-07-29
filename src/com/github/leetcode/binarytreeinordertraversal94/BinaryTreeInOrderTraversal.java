package com.github.leetcode.binarytreeinordertraversal94;

import java.util.ArrayList;
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
}
