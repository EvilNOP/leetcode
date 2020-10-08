package com.github.leetcode.reversestring344;

public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(s, left, right);
            ++left;
            --right;
        }
    }

    public void swap(char[] s, int i, int j) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
