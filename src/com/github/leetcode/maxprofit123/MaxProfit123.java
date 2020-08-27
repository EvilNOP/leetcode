package com.github.leetcode.maxprofit123;

public class MaxProfit123 {

    public int maxProfit(int[] prices) {
        int maxDeal = 2;
        int[][][] dp = new int[prices.length][maxDeal + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int k = maxDeal; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];

                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][1] + prices[i], dp[i - 1][k][0]);
                dp[i][k][1] = Math.max(dp[i - 1][k - 1][0] - prices[i], dp[i - 1][k][1]);
            }
        }

        return dp[prices.length - 1][maxDeal][0];
    }

    public int maxProfit(int[] prices, int buy, int deal) {
        if (buy == prices.length || deal == 0) {
            return 0;
        }

        int lowestPrice = prices[buy];
        int maxProfit = 0;

        for (int i = buy + 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            maxProfit = Math.max(maxProfit, maxProfit(prices, i + 1, deal - 1) + prices[i] - lowestPrice);
        }

        return maxProfit;
    }
}
