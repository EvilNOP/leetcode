package com.github.leetcode.removekdigits402;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char digit = num.charAt(i);

            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                --k;
            }

            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;

        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();

            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            ret.append(digit);
        }

        return ret.length() == 0 ? "0" : ret.toString();
    }
}
