package com.github.leetcode.maxprofit188;

public class MaxProfit188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if (k > n / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[prices.length][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int deal = k; deal > 0; deal--) {
                if (i - 1 == -1) {
                    dp[i][deal][0] = 0;
                    dp[i][deal][1] = -prices[i];

                    continue;
                }

                dp[i][deal][0] = Math.max(dp[i - 1][deal][1] + prices[i], dp[i - 1][deal][0]);
                dp[i][deal][1] = Math.max(dp[i - 1][deal - 1][0] - prices[i], dp[i - 1][deal][1]);
            }
        }

        return dp[n - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
