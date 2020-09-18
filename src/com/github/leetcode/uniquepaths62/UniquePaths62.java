package com.github.leetcode.uniquepaths62;

import java.util.Arrays;

public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }

        return dp[0];
    }
}
