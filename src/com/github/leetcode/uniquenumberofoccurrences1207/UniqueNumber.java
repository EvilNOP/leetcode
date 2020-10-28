package com.github.leetcode.uniquenumberofoccurrences1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumber {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int x : arr) {
            occurrences.put(x, occurrences.getOrDefault(x, 0) + 1);
        }

        Set<Integer> times = new HashSet<>();

        for (Map.Entry<Integer, Integer> x : occurrences.entrySet()) {
            times.add(x.getValue());
        }

        return times.size() == occurrences.size();
    }
}
