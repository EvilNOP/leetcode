package com.github.leetcode.permutations47;

import java.util.*;

public class Permutations47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        Deque<Integer> path = new ArrayDeque<>(n);
        List<List<Integer>> res = new ArrayList<>(n);

        Arrays.sort(nums);
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

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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
