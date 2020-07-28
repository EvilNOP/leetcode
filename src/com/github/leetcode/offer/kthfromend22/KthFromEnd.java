package com.github.leetcode.offer.kthfromend22;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class KthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        while (--k > 0 && fast != null) {
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
