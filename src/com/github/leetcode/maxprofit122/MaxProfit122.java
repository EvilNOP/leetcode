package com.github.leetcode.maxprofit122;

public class MaxProfit122 {

    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2];

//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];

        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            cash = Math.max(hold + prices[i], cash);

//            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            hold = Math.max(cash - prices[i], hold);
        }

//        return dp[prices.length - 1][0];
        return cash;
    }

    public int maxProfitLeetcode(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices, int buy) {
        if (buy == prices.length) {
            return 0;
        }

        int lowestPrice = prices[buy];
        int maxProfit = 0;

        for (int i = buy + 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else if ((prices[i] - lowestPrice) > maxProfit) {
                maxProfit = (prices[i] - lowestPrice) + maxProfit(prices, i + 1);
            }
        }

        return maxProfit;
    }
}
