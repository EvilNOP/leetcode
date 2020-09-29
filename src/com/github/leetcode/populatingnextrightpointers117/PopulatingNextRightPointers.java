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

    Node previousNode;
    Node nextStart;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node start = root;

        while (start != null) {
            previousNode = null;
            nextStart = null;

            for (Node temp = start; temp != null; temp = temp.next) {
                if (temp.left != null) {
                    handle(temp.left);
                }

                if (temp.right != null) {
                    handle(temp.right);
                }
            }

            start = nextStart;
        }

        return root;
    }

    public void handle(Node node) {
        if (previousNode != null) {
            previousNode.next = node;
        }

        if (nextStart == null) {
            nextStart = node;
        }

        previousNode = node;
    }
}
