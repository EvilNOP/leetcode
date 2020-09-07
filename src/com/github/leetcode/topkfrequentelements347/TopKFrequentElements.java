package com.github.leetcode.topkfrequentelements347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue())
        );

        for (Map.Entry<Integer, Integer> integerIntegerEntry : occurrences.entrySet()) {
            priorityQueue.offer(integerIntegerEntry);
        }

        int[] topK = new int[k];

        for (int i = 0; i < k; i++) {
            topK[i] = priorityQueue.poll().getKey();
        }

        return topK;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1}, 1));
    }
}
