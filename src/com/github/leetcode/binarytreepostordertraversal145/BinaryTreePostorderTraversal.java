package com.github.leetcode.binarytreepostordertraversal145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        postorderTraversal(root, traversal);

        return traversal;
    }

    public void postorderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, traversal);
        postorderTraversal(root.right, traversal);

        traversal.add(root.val);
    }

    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        TreeNode previous = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null || root.right == previous) {
                ans.add(root.val);
                previous = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return ans;
    }
}
