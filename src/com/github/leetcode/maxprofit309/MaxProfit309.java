package com.github.leetcode.maxprofit309;

public class MaxProfit309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

//        int[][] dp = new int[prices.length][3];

        int cash = 0;
        int hold = -prices[0];
        int freezed = 0;

//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = cash;
            cash = Math.max(hold + prices[i], cash);
            hold = Math.max(freezed - prices[i], hold);
            freezed = temp;
//            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
//            dp[i][1] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][1]);
//            dp[i][2] = dp[i - 1][0];
        }

        return cash;
//        return dp[prices.length - 1][0];
    }
}
