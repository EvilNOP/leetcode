package com.github.leetcode.supereggdrop887;

import java.util.HashMap;

public class SuperEggDrop {

    private final HashMap<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int k, int n) {
        if (n == 0) {
            return 0;
        }

        if (k == 1) {
            return n;
        }

        String key = k + ":" + n;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minDropsCount = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            minDropsCount = Math.min(
                    minDropsCount,
                    Math.max(dp(k - 1, i - 1), dp(k, n - i)) + 1
            );
        }

        memo.put(key, minDropsCount);

        return minDropsCount;
    }
}
