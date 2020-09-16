package com.github.leetcode.longestincreasingsubsequence300;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int maxLen = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int maxValue = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > maxValue) {
                    maxValue = dp[j] + 1;
                    dp[i] = maxValue;
                }
            }

            if (maxValue > maxLen) {
                maxLen = maxValue;
            }
        }

        return maxLen;
    }
}
