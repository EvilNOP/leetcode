package com.github.leetcode.uniquepaths63;

public class UniquePaths63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[n - 1] = obstacleGrid[m - 1][n - 1] == 0 ? 1 : 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j + 1 < n && obstacleGrid[i][j + 1] == 0) {
                    dp[j] += dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}
