package com.github.leetcode.coinchange322;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {

    private final HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChangeRecursion(int[] coins, int amount) {
        if (memo.get(amount) != null) {
            return memo.get(amount);
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subProblem = coinChangeRecursion(coins, amount - coin);

            if (subProblem == -1) {
                continue;
            }

            result = Math.min(result, subProblem + 1);
        }

        result = result != Integer.MAX_VALUE ? result : -1;

        memo.put(amount, result);

        return result;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
