package com.github.leetcode.insertinterval57;

import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean placed = false;
        int left = newInterval[0];
        int right = newInterval[1];
        ArrayList<int[]> ansIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    ansIntervals.add(new int[]{left, right});
                    placed = true;
                }

                ansIntervals.add(interval);
            } else if (interval[1] < left) {
                ansIntervals.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!placed) {
            ansIntervals.add(new int[]{left, right});
        }

        int[][] ans = new int[ansIntervals.size()][2];

        for (int i = 0; i < ansIntervals.size(); i++) {
            ans[i] = ansIntervals.get(i);
        }

        return ans;
    }
}
