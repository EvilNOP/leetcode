package com.github.leetcode.triangle120;

import java.util.List;

public class TriangleRecursive {

    private Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle, int n, int i, int j) {
        if (i >= n - 1) {
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int leftSum = minimumTotal(triangle, n, i + 1, j);
        int rightSum = minimumTotal(triangle, n, i + 1, j + 1);
        int result = triangle.get(i).get(j) + Math.min(leftSum, rightSum);

        memo[i][j] = result;

        return result;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return minimumTotal(triangle, n, 0, 0);
    }
}
