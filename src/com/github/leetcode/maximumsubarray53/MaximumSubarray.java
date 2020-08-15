package com.github.leetcode.maximumsubarray53;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int previousSum = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            previousSum = Math.max(previousSum + num, num);
            maxSum = Math.max(previousSum, maxSum);
        }

        return maxSum;
    }

    public int maxSubArrayGreedy(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int maxSum = sum;

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
