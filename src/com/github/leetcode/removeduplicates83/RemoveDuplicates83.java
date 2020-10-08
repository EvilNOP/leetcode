package com.github.leetcode.removeduplicates83;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveDuplicates83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = fast;
            }

            fast = fast.next;
        }

        slow.next = null;

        return head;
    }
}
