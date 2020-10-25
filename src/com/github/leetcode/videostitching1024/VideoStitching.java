package com.github.leetcode.videostitching1024;

import java.util.Arrays;

public class VideoStitching {

    public int videoStitching(int[][] clips, int T) {
        int[] longest = new int[T];

        for (int[] clip : clips) {
            if (clip[0] < T) {
                longest[clip[0]] = Math.max(longest[clip[0]], clip[1]);
            }
        }

        int previous = 0;
        int last = 0;
        int ans = 0;

        for (int i = 0; i < T; i++) {
            last = Math.max(last, longest[i]);

            if (i == last) {
                return -1;
            }

            if (i == previous) {
                ++ans;
                previous = last;
            }
        }

        return ans;
    }

    public int videoStitchingDP(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }

        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
