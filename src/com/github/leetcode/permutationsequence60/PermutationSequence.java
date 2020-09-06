package com.github.leetcode.permutationsequence60;

public class PermutationSequence {

    private int[] factorial;

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        calculateFactorial(n);

        StringBuilder pathBuilder = new StringBuilder();
        backtrack(0, n, used, pathBuilder, k);

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
