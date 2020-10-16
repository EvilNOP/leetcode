package com.github.leetcode.squaresofsortedarray977;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int negative = -1;

        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int index = 0;
        int i = negative;
        int j = negative + 1;

        int[] ans = new int[n];

        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }

            ++index;
        }

        return ans;
    }
}
