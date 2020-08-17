package com.github.leetcode.maxprofit121;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else if ((price - lowestPrice) > maxProfit) {
                maxProfit = price - lowestPrice;
            }
        }

        return maxProfit;
    }
}
