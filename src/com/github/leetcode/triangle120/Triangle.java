package com.github.leetcode.triangle120;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> memo = triangle.get(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                memo.set(j, triangle.get(i).get(j) + Math.min(memo.get(j), memo.get(j + 1)));
            }
        }

        return memo.get(0);
    }
}
