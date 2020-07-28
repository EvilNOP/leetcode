package com.github.leetcode.reverseKGroup25;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Pair<T> {

    T first;
    T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

public class ReverseKGroup {

    public Pair<ListNode> reverse(ListNode head, ListNode tail) {
        ListNode previous = tail.next;
        ListNode current = head;

        while (previous != tail) {
            ListNode next = current.next;

            current.next = previous;
            previous = current;

            current = next;
        }

        return new Pair<>(tail, head);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode previous = sentinel;

        while (head != null) {
            ListNode tail = previous;

            for (int i = 0; i < k; i++) {
                tail = tail.next;

                if (tail == null) {
                    return sentinel.next;
                }
            }

            Pair<ListNode> pair = reverse(head, tail);
            head = pair.getFirst();
            tail = pair.getSecond();

            previous.next = head;
            previous = tail;
            head = tail.next;
        }

        return sentinel.next;
    }
}
