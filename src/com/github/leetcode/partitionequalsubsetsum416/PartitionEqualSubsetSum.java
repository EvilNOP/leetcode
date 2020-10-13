package com.github.leetcode.partitionequalsubsetsum416;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return false;
        }

        int sum = 0;
        int maxSum = 0;

        for (int num : nums) {
            sum += num;

            if (num > maxSum) {
                maxSum = num;
            }
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        if (maxSum > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][target];
    }
}
