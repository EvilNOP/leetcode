package com.github.leetcode.longestpalindrome409;

class Pair<T> {

    T first;
    T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        char[] sCharArray = s.toCharArray();
        Pair<Integer> pair = new Pair<>(0, 0);

        for (int i = 0; i < sCharArray.length; i++) {
            Pair<Integer> pair1 = palindrome(sCharArray, i, i);
            Pair<Integer> pair2 = palindrome(sCharArray, i, i + 1);

            if ((pair1.second - pair1.first) > (pair.second - pair.first)) {
                pair = pair1;
            }

            if ((pair2.second - pair2.first) > (pair.second - pair.first)) {
                pair = pair2;
            }
        }

        return s.substring(pair.first, pair.second + 1);
    }

    public Pair<Integer> palindrome(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }

        return new Pair<>(left + 1, right - 1);
    }
}
