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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        ListNode slow = sentinel;
        ListNode fast = head;

        while (--n >= 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return sentinel.next;
    }
}
