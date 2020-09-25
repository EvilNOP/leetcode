package com.github.leetcode.longestpalindromicsubsequence516;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] sCharArray = s.toCharArray();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (sCharArray[i] == sCharArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    if (dp[i + 1][j] > dp[i][j]) {
                        dp[i][j] = dp[i + 1][j];
                    }

                    if (dp[i][j - 1] > dp[i][j]) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public int longestPalindromeSubseqOptimizeSpace(String s) {
        int n = s.length();
        char[] sCharArray = s.toCharArray();

        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int max = 0;

            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];

                if (sCharArray[i] == sCharArray[j]) {
                    dp[j] = max + 2;
                }

                if (temp > max) {
                    max = temp;
                }
            }
        }

        int max = 0;

        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}
