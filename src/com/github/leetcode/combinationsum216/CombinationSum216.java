package com.github.leetcode.combinationsum216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum216 {

    public List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        backtrack(1, 9, k, n, path, combinations);

        return combinations;
    }

    public void backtrack(int begin, int end, int k, int target, Deque<Integer> path, List<List<Integer>> combinations) {
        if (path.size() + (end - begin + 1) < k) {
            return;
        }

        if (k == 0 && target == 0) {
            combinations.add(new ArrayList<>(path));

            return;
        }

        for (int i = begin; i <= end; i++) {
            // Pruning branches.
            if (target - i < 0) {
                break;
            }

            path.addLast(i);
            backtrack(i + 1, end, k - 1, target - i, path, combinations);
            path.removeLast();
        }
    }
}
