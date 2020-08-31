package com.github.leetcode.dailytemperatures739;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return ans;
    }
}
