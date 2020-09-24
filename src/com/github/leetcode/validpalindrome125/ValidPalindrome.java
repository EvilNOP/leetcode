package com.github.leetcode.validpalindrome125;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] sCharArray = s.toCharArray();

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(sCharArray[left])) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(sCharArray[right])) {
                right--;
            }

            if (left < right) {
                if (Character.toLowerCase(sCharArray[left]) != Character.toLowerCase(sCharArray[right])) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
