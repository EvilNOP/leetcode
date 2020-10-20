package com.github.leetcode.reorderlist143;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode middle = middleNode(head);
        ListNode node1 = head;
        ListNode node2 = middle.next;
        middle.next = null;

        node2 = reverseList(node2);

        mergeList(node1, node2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public void mergeList(ListNode node1, ListNode node2) {
        ListNode temp1;
        ListNode temp2;

        while (node1 != null && node2 != null) {
            temp1 = node1.next;
            temp2 = node2.next;

            node1.next = node2;
            node1 = temp1;

            node2.next = node1;
            node2 = temp2;
        }
    }
}
