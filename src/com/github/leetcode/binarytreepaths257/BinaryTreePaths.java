package com.github.leetcode.binarytreepaths257;

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

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, "", paths);

        return paths;
    }

    public void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append(root.val);

        if (root.left == null && root.right == null) {
            paths.add(stringBuilder.toString());
        } else {
            stringBuilder.append("->");

            path = stringBuilder.toString();
            binaryTreePaths(root.left, path, paths);
            binaryTreePaths(root.right, path, paths);
        }
    }
}
