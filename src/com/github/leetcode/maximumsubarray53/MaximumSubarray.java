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

    public int maxSubArrayRecursively(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (low + high) / 2;
        int leftSum = maxSubArrayRecursively(nums, low, mid);
        int rightSum = maxSubArrayRecursively(nums, mid + 1, high);
        int crossSum = findMaximumCrossingSubarray(nums, low, mid, high);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int findMaximumCrossingSubarray(int[] nums, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += nums[i];

            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];

            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        return leftMax + rightMax;
    }
}
