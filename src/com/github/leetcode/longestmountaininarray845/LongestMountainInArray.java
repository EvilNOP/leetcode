package com.github.leetcode.longestmountaininarray845;

public class LongestMountainInArray {

    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;

        while (left + 2 < n) {
            int right = left + 1;

            if (A[left] < A[right]) {
                while (right < n - 1 && A[right] < A[right + 1]) {
                    ++right;
                }

                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right < n - 1 && A[right] > A[right + 1]) {
                        ++right;
                    }

                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }

            left = right;
        }

        return ans;
    }
}
