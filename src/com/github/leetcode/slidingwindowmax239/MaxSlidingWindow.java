package com.github.leetcode.slidingwindowmax239;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class MonotonicQueue {

    private final ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    public void add(int num) {
        while (!arrayDeque.isEmpty() && arrayDeque.getLast() < num) {
            arrayDeque.removeLast();
        }

        arrayDeque.addLast(num);
    }

    public void remove(int num) {
        if (!arrayDeque.isEmpty() && arrayDeque.getFirst() == num) {
            arrayDeque.removeFirst();
        }
    }

    public Integer front() {
        return arrayDeque.getFirst();
    }
}

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n * k == 0) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);
        }

        int max;

        for (int i = k - 1; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);
            max = deque.getFirst();
            ans[i - k + 1] = max;

            if (max == nums[i - k + 1]) {
                deque.removeFirst();
            }
        }

        return ans;
    }
}
