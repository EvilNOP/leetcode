package com.github.leetcode.palindromelinkedlist234;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode reversedHead = reverseLinkedList(slow);

        while (reversedHead != null) {
            if (head.val != reversedHead.val) {
                return false;
            }

            head = head.next;
            reversedHead = reversedHead.next;
        }

        return true;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
    }
}
