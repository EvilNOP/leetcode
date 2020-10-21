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

        int low = 1;
        int high = n;
        int minDropsCount = Integer.MAX_VALUE;

        while (low <= high) {
            int middle = (low + high) / 2;

            int t1 = dp(k - 1, middle - 1);
            int t2 = dp(k, n - middle);

            if (t1 > t2) {
                high = middle - 1;
                minDropsCount = Math.min(minDropsCount, t1 + 1);
            } else {
                low = middle + 1;
                minDropsCount = Math.min(minDropsCount, t2 + 1);
            }
        }

        memo.put(key, minDropsCount);

        return minDropsCount;
    }
}
