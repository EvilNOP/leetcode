package com.github.leetcode.combinations77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> combination = new ArrayDeque<>();
        List<List<Integer>> combinations = new ArrayList<>();

        combine(n, 1, k, combination, combinations);

        return combinations;
    }

    public void combine(int n, int i, int k, Deque<Integer> combination, List<List<Integer>> combinations) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));

            return;
        }

        // Before pruning branches, j < n + 1
        for (int j = i; j <= n - (k - combination.size()) + 1; j++) {
            combination.addLast(j);
            combine(n, j + 1, k, combination, combinations);
            combination.removeLast();
        }
    }
}
