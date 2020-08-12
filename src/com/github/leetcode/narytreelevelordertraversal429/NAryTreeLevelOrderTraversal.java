package com.github.leetcode.narytreelevelordertraversal429;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> nodeValues = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                nodeValues.add(node.val);

                queue.addAll(node.children);
            }

            res.add(nodeValues);
        }

        return res;
    }
}
