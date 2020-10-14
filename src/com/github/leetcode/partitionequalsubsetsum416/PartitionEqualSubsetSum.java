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

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        dp[nums[0]] = true;

        for (int i = 1; i < n; i++) {
            int num = nums[i];

            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        return dp[target];
    }
}
