package com.github.leetcode.linkedlistcycle142;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode loopNode = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopNode = slow;
                break;
            }
        }

        if (loopNode == null) {
            return null;
        }

        while (head != loopNode) {
            head = head.next;
            loopNode = loopNode.next;
        }

        return head;
    }
}
