package com.github.leetcode.searchrange34;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (nums[mid] == target) {
                    ans[0] = mid;
                }

                high = mid - 1;
            }
        }

        if (ans[0] == -1) {
            return ans;
        }

        ans[1] = ans[0];
        low = ans[0] + 1;
        high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[mid] == target) {
                    ans[1] = mid;
                }

                low = mid + 1;
            }
        }

        return ans;
    }
}
