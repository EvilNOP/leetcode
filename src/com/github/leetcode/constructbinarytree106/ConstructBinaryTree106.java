package com.github.leetcode.constructbinarytree106;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ConstructBinaryTree106 {

    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        postIndex = postorder.length - 1;

        int index = 0;
        for (Integer val : inorder) {
            indexMap.put(val, index++);
        }

        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode treeNode = new TreeNode(rootVal);

        int index = indexMap.get(rootVal);

        treeNode.right = helper(index + 1, inRight);
        treeNode.left = helper(inLeft, index - 1);

        return treeNode;
    }
}
