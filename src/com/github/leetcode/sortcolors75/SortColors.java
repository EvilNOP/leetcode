package com.github.leetcode.sortcolors75;

public class SortColors {

    public void sortColors(int[] nums) {
        int nextStart = sortColors(nums, 0, 0);
        sortColors(nums, nextStart, 1);
    }

    public int sortColors(int[] nums, int start, int color) {
        int end = start;

        for (int i = start; i < nums.length; i++) {
            if (nums[i] == color) {
                swap(nums, end, i);
                ++end;
            }
        }

        return end;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
