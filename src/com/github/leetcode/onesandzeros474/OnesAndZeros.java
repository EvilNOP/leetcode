package com.github.leetcode.onesandzeros474;

public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] count = countZerosOnes(str);

            for (int zeros = m; zeros >= count[0]; zeros--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeros][ones] = Math.max(dp[zeros][ones], dp[zeros - count[0]][ones - count[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public int[] countZerosOnes(String s) {
        int[] count = new int[2];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }

        return count;
    }
}
