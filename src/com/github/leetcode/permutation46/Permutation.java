package com.github.leetcode.permutation46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        Deque<Integer> path = new ArrayDeque<>(n);
        List<List<Integer>> res = new ArrayList<>(n);

        backtrack(0, n, nums, used, path, res);

        return res;
    }

    public void backtrack(int depth, int n, int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == n) {
            res.add(new ArrayList<>(path));

            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);

            backtrack(depth + 1, n, nums, used, path, res);

            used[i] = false;
            path.removeLast();
        }
    }
}
