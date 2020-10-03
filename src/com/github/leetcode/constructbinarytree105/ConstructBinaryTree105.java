package com.github.leetcode.constructbinarytree105;

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

public class ConstructBinaryTree105 {

    int preIndex;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIndex = 0;
        this.preorder = preorder;
        this.inorder = inorder;

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

        int rootVal = preorder[preIndex++];
        int index = indexMap.get(rootVal);

        TreeNode treeNode = new TreeNode(rootVal);

        treeNode.left = helper(inLeft, index - 1);
        treeNode.right = helper(index + 1, inRight);

        return treeNode;
    }
}
