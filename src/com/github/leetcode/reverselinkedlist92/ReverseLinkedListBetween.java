package com.github.leetcode.reverselinkedlist92;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedListBetween {

    public ListNode reverseList(ListNode from, ListNode to) {
        ListNode previous = null;
        ListNode current = from;
        ListNode end = null;

        if (to != null) {
            end = to.next;
        }

        while (current != end) {
            ListNode next = current.next;

            current.next = previous;
            previous = current;

            current = next;
        }

        return previous;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headConnection = null;
        ListNode from = null;
        ListNode to = null;
        ListNode tailConnection = null;
        ListNode temp = head;

        int currentIndex = 1;

        while (temp != null) {
            if (currentIndex == m - 1) {
                headConnection = temp;
            } else if (currentIndex == m) {
                from = temp;
            } else if (currentIndex == n) {
                to = temp;
            } else if (currentIndex == n + 1) {
                tailConnection = temp;
            }

            temp = temp.next;
            currentIndex++;
        }

        if (from == null || to == null) {
            return head;
        }

        ListNode newHead = reverseList(from, to);

        if (headConnection != null) {
            headConnection.next = to;
        } else {
            head = newHead;
        }

        from.next = tailConnection;

        return head;
    }
}
