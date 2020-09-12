package com.github.leetcode.averageoflevels637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        if (root == null) {
            return averages;
        }

        double sum;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double n = queue.size();
            sum = 0.0;

            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                assert treeNode != null;
                sum += treeNode.val;

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            averages.add(sum / n);
        }

        return averages;
    }
}
