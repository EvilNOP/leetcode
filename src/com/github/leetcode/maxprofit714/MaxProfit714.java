package com.github.leetcode.maxprofit714;

public class MaxProfit714 {

    public int maxProfit(int[] prices, int fee, int buy) {
        if (buy == prices.length) {
            return 0;
        }

        int lowestPrice = prices[buy];
        int maxProfit = 0;

        for (int i = buy + 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            maxProfit = Math.max(maxProfit, maxProfit(prices, fee, i + 1) + prices[i] - lowestPrice - fee);
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(hold + prices[i] - fee, cash);
            hold = Math.max(cash - prices[i], hold);
        }

        return cash;
    }
}
