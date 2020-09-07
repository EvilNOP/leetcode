package com.github.leetcode.permutationsequence60;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

    private int[] factorial;

    public String getPermutationBacktrack(int n, int k) {
        boolean[] used = new boolean[n + 1];
        calculateFactorial(n);

        StringBuilder pathBuilder = new StringBuilder();
        backtrack(0, n, used, pathBuilder, k);

        return pathBuilder.toString();
    }

    public String getPermutation(int n, int k) {
        --k;
        calculateFactorial(n);

        StringBuilder pathBuilder = new StringBuilder();
        List<Integer> nums = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            pathBuilder.append(nums.remove(index));
            k -= index * factorial[i];
        }

        return pathBuilder.toString();
    }

    public void backtrack(int depth, int n, boolean[] used, StringBuilder pathBuilder, int k) {
        if (depth == n) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }

            int count = factorial[n - 1 - depth];

            if (count < k) {
                k -= count;
                continue;
            }

            used[i] = true;
            pathBuilder.append(i);

            backtrack(depth + 1, n, used, pathBuilder, k);

            return;
        }
    }

    public void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
