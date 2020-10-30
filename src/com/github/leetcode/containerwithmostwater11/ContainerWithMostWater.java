package com.github.leetcode.containerwithmostwater11;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * minHeight);

            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return max;
    }
}
