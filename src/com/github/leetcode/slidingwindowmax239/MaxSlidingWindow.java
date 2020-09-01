package com.github.leetcode.slidingwindowmax239;

import java.util.ArrayDeque;

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

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n * k == 0) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] ans = new int[n - k + 1];
        MonotonicQueue monotonicQueue = new MonotonicQueue();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonicQueue.add(nums[i]);
            } else {
                monotonicQueue.add(nums[i]);
                ans[i - k + 1] = monotonicQueue.front();
                monotonicQueue.remove(nums[i - k + 1]);
            }
        }

        return ans;
    }
}
