package com.github.leetcode.topkfrequentelements347;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(m -> m[1]));

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                assert queue.peek() != null;

                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];

        for (int i = 0; i < k; ++i) {
            ret[i] = Objects.requireNonNull(queue.poll())[0];
        }

        return ret;
    }

    public int[] topKFrequentQuickSort(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            values.add(new int[]{key, value});
        }

        int[] ans = new int[k];
        quickSort(0, values.size() - 1, 0, k, values, ans);

        return ans;
    }

    public void quickSort(int start, int end, int cursor, int k, List<int[]> values, int[] ans) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, start, picked);

        int pivot = values.get(start)[1];
        int index = start;

        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, ++index, i);
            }
        }

        Collections.swap(values, start, index);

        if (k <= (index - start)) {
            quickSort(start, index - 1, cursor, k, values, ans);
        } else {
            for (int i = start; i <= index; i++) {
                ans[cursor++] = values.get(i)[0];
            }

            if (k > (index - start + 1)) {
                quickSort(index + 1, end, cursor, k - (index - start + 1), values, ans);
            }
        }
    }
}
