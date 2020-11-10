package com.github.leetcode.kclosest973;

import java.util.Objects;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((array1, array2) -> array2[0] - array1[0]);

        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }

        int n = points.length;

        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            assert pq.peek() != null;

            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }

        int[][] ans = new int[K][2];

        for (int i = 0; i < K; ++i) {
            ans[i] = points[Objects.requireNonNull(pq.poll())[1]];
        }

        return ans;
    }
}
