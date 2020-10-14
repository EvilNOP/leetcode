package com.github.leetcode.minimumdifferenceinbst530;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MinimumAbsoluteDifferenceInBST {

    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);

        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;

        dfs(root.right);
    }
}
