package com.github.leetcode.maxprofit122;

public class MaxProfit122 {

    public int maxProfit(int[] prices) {
        int lowestPriceIndex = 0;
        int highPriceIndex = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[highPriceIndex]) {
                maxProfit += (prices[highPriceIndex] - prices[lowestPriceIndex]);

                lowestPriceIndex = i;
            }
            highPriceIndex = i;

            if (prices[i] < prices[lowestPriceIndex]) {
                lowestPriceIndex = i;
                highPriceIndex = i;
            }
        }

        if (highPriceIndex == prices.length - 1) {
            maxProfit += (prices[highPriceIndex] - prices[lowestPriceIndex]);
        }

        return maxProfit;
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
