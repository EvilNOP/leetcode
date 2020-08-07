package com.github.leetcode.countingbits338;

public class CountingBits {

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];

        for (int i = 1; i < num + 1; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }

        return bits;
    }
}
