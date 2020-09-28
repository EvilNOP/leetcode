package com.github.leetcode.populatingnextrightpointers117;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointers {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node parent = root;
        Node leftMostNode = root.left != null ? root.left : root.right;

        while (leftMostNode != null) {
            Node previousNode = null;

            while (parent != null) {
                if (previousNode != null) {
                    previousNode.next = parent.left != null ? parent.left : parent.right;
                }

                if (parent.left != null && parent.right != null) {
                    parent.left.next = parent.right;
                    previousNode = parent.right;
                }

                if (parent.left != null && parent.right == null) {
                    previousNode = parent.left;
                }

                if (parent.left == null && parent.right != null) {
                    previousNode = parent.right;
                }

                parent = parent.next;
            }

            while (parent == null && leftMostNode != null) {
                if (leftMostNode.left != null || leftMostNode.right != null) {
                    parent = leftMostNode;
                    break;
                }

                leftMostNode = leftMostNode.next;
            }

            if (parent != null) {
                leftMostNode = leftMostNode.left != null ? leftMostNode.left : leftMostNode.right;
            }
        }

        return root;
    }
}
