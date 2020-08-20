package com.github.leetcode.maxprofit123;

public class MaxProfit123 {

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 2);
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
