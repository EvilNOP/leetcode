package com.github.leetcode.subsets78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<Integer> subset = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int current, int[] nums) {
        if (current == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[current]);
        dfs(current + 1, nums);
        subset.remove(subset.size() - 1);
        dfs(current + 1, nums);
    }
}
