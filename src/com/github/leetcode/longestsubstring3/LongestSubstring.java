package com.github.leetcode.longestsubstring3;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int maxLen = 0;
        char[] sCharArray = s.toCharArray();
        int[] frequency = new int[128];

        while (rightIndex < s.length()) {
            char c1 = sCharArray[rightIndex];
            frequency[c1]++;
            rightIndex++;

            while (frequency[c1] > 1) {
                frequency[sCharArray[leftIndex]]--;
                leftIndex++;
            }

            if (rightIndex - leftIndex + 1 > maxLen) {
                maxLen = rightIndex - leftIndex;
            }
        }

        return maxLen;
    }
}
