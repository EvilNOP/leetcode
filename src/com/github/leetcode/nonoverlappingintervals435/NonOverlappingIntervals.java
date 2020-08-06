package com.github.leetcode.nonoverlappingintervals435;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervalsGreedy(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalComparator());

        int previous = 0;
        int max = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[previous][1]) {
                previous = i;
                max += 1;
            }
        }

        return intervals.length - max;
    }

    private boolean isOverlapping(int[] a, int[] b) {
        return a[1] > b[0];
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalComparator());
        int[] dp = new int[intervals.length];
        dp[0] = 1;

        for (int i = 1; i < intervals.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (!isOverlapping(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = (max + 1);
        }

        return intervals.length - dp[intervals.length - 1];
    }

    class IntervalComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}
