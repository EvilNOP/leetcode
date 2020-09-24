package com.github.leetcode.longestpalindrome409;

public class LongestPalindrome {

    public String longestPalindromeDP(String s) {
        int n = s.length();

        if (n <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        char[] sCharArray = s.toCharArray();

        int left = 0;
        int right = 0;

        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;

                if (len == 0) {
                    dp[i][j] = true;
                } else if (len == 1) {
                    dp[i][j] = sCharArray[i] == sCharArray[j];
                } else {
                    dp[i][j] = sCharArray[i] == sCharArray[j] && dp[i + 1][j - 1];
                }

                if (dp[i][j] && ((j - i) > (right - left))) {
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        char[] sCharArray = s.toCharArray();
        int left = 0;
        int right = 0;

        for (int i = 0; i < sCharArray.length; i++) {
            int len = 0;
            int oddPalindromeLen = expandAroundCenter(sCharArray, i, i);
            int evenPalindromeLen = expandAroundCenter(sCharArray, i, i + 1);

            if (oddPalindromeLen > len) {
                len = oddPalindromeLen;
            }

            if (evenPalindromeLen > len) {
                len = evenPalindromeLen;
            }

            if (len > (right - left)) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    public int expandAroundCenter(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
