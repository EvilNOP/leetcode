package com.github.leetcode.validpalindrome680;

public class ValidPalindrome680 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] sCharArray = s.toCharArray();

        while (left < right) {
            if (sCharArray[left] == sCharArray[right]) {
                ++left;
                --right;
            } else {
                return validPalindrome(sCharArray, left + 1, right) || validPalindrome(sCharArray, left, right - 1);
            }
        }

        return true;
    }

    public boolean validPalindrome(char[] sCharArray, int left, int right) {
        while (left < right) {
            if (sCharArray[left] != sCharArray[right]) {
                return false;
            }

            ++left;
            --right;
        }

        return true;
    }
}
