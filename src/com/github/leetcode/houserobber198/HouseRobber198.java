package com.github.leetcode.houserobber198;

public class HouseRobber198 {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }
}
