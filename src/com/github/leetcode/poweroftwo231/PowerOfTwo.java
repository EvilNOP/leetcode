package com.github.leetcode.poweroftwo231;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        return ((long) n & ((long) n - 1)) == 0;
    }
}
