package com.github.leetcode.longestsubstring3;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int maxLen = 0;
        boolean repeated = false;
        char[] sCharArray = s.toCharArray();
        int[] indexes = new int[128];
        int[] frequency = new int[128];

        while (rightIndex < s.length()) {
            char c1 = sCharArray[rightIndex];
            frequency[c1]++;

            if (frequency[c1] > 1) {
                repeated = true;
            }

            if (repeated) {
                int newLeftIndex = leftIndex + (indexes[c1] - leftIndex + 1);

                while (leftIndex < newLeftIndex) {
                    frequency[sCharArray[leftIndex]]--;
                    leftIndex++;
                }

                repeated = false;
            }

            indexes[c1] = rightIndex;

            if (rightIndex - leftIndex + 1 > maxLen) {
                maxLen = rightIndex - leftIndex + 1;
            }

            rightIndex++;
        }

        return maxLen;
    }
}
