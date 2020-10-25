package com.github.leetcode.videostitching1024;

public class VideoStitching {

    public static int videoStitching(int[][] clips, int T) {
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
}
