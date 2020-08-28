package com.github.leetcode.maxprofit123;

public class MaxProfit123 {

    public int maxProfit(int[] prices) {
//        int maxDeal = 2;
//        int[][][] dp = new int[prices.length][maxDeal + 1][2];

        int dpI20 = 0;
        int dpI21 = -prices[0];
        int dpI10 = 0;
        int dpI11 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
//            dp[i][2][0] = Math.max(dp[i - 1][2][1] + prices[i], dp[i - 1][2][0]);
//            dp[i][2][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][2][1]);
//            dp[i][1][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][1][0]);
//            dp[i][1][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][1]);

            dpI20 = Math.max(dpI21 + prices[i], dpI20);
            dpI21 = Math.max(dpI10 - prices[i], dpI21);
            dpI10 = Math.max(dpI11 + prices[i], dpI10);
            dpI11 = Math.max(-prices[i], dpI11);
        }

//        return dp[prices.length - 1][maxDeal][0];
        return dpI20;
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
