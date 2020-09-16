package com.github.leetcode.longestincreasingsubsequence300;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
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

    public int lengthOfLISGreedy(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int end = 0;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[end]) {
                end++;
                dp[end] = nums[i];
            } else {
                int left = 0;
                int right = end;

                while (left < right) {
                    int mid = (left + right) >>> 1;

                    if (nums[i] > dp[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                dp[left] = nums[i];
            }
        }

        return end + 1;
    }
}
