package com.github.leetcode.combinations77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();

        List<List<Integer>> res = combinations.combine(4, 2);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

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

        for (int j = i; j < n + 1; j++) {
            combination.addLast(j);
            combine(n, j + 1, k, combination, combinations);
            combination.removeLast();
        }
    }

//    public void combine(int[] nums, int n, int i, int k, Deque<Integer> combination, List<List<Integer>> combinations) {
//        if (i >= n) {
//            return;
//        }
//
//        if (combination.size() == k) {
//            combinations.add(new ArrayList<>(combination));
//
//            return;
//        }
//
//        combination.addLast(nums[i]);
//
//        combine(nums, n, i + 1, k, combination, combinations);
//
//        combination.removeLast();
//    }

    public int selectedCount(boolean[] selected) {
        int count = 0;

        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                count++;
            }
        }

        return count;
    }
}
