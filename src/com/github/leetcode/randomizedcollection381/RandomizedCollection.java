package com.github.leetcode.randomizedcollection381;

import java.util.*;

public class RandomizedCollection {

    private final ArrayList<Integer> nums;
    private final Map<Integer, Set<Integer>> indexes;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        indexes = new HashMap<>();
    }

    public boolean insert(int val) {
        nums.add(val);

        Set<Integer> set = indexes.getOrDefault(val, new HashSet<>());
        set.add(nums.size() - 1);
        indexes.put(val, set);

        return set.size() == 1;
    }

    public boolean remove(int val) {
        if (indexes.get(val) == null) {
            return false;
        }

        int i = indexes.get(val).iterator().next();
        int lastNum = nums.get(nums.size() - 1);

        nums.set(i, lastNum);

        indexes.get(val).remove(i);
        indexes.get(lastNum).remove(nums.size() - 1);

        if (i < nums.size() - 1) {
            indexes.get(lastNum).add(i);
        }

        if (indexes.get(val).size() == 0) {
            indexes.remove(val);
        }

        nums.remove(nums.size() - 1);

        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
