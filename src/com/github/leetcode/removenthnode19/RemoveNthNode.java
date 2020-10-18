package com.github.leetcode.removenthnode19;

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

public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int k = n;
        ListNode slow = head;
        ListNode fast = head;

        while (--k > 0 && fast != null) {
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode previous = sentinel;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            previous = previous.next;
        }

        if (n == 1) {
            previous.next = null;
        } else {
            previous.next = slow.next;
        }

        return sentinel.next;
    }
}
