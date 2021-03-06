package com.github.leetcode.combinationsum40;

import java.util.*;

public class CombinationSum40 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> combinations = new ArrayList<>();

        if (n == 0) {
            return combinations;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(candidates.length, 0, candidates, target, path, combinations);

        return combinations;
    }

    public void backtrack(int n, int begin, int[] candidates, int target, Deque<Integer> path, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(path));
        }

        for (int i = begin; i < n; i++) {
            // Pruning branches.
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            backtrack(n, i + 1, candidates, target - candidates[i], path, combinations);
            path.removeLast();
        }
    }
}
