package com.github.leetcode.swapnodesinpairs24;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode previous = sentinel;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            previous.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            previous = firstNode;
            head = firstNode.next;
        }

        return sentinel.next;
    }

    public ListNode swapPairsRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondNode = head.next;

        head.next = swapPairs(secondNode.next);
        secondNode.next = head;

        return secondNode;
    }
}
