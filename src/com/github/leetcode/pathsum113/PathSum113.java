package com.github.leetcode.pathsum113;

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

public class PathSum113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, path, ans);

        return ans;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList<>(path));
        }

        pathSum(root.left, sum - root.val, path, ans);
        pathSum(root.right, sum - root.val, path, ans);

        path.remove(path.size() - 1);
    }
}
