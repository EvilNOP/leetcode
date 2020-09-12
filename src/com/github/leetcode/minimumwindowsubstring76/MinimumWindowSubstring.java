package com.github.leetcode.minimumwindowsubstring76;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int begin = 0;
        int minLength = Integer.MAX_VALUE;
        int distance = 0;

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        int[] tFrequency = new int[128];
        int[] windowFrequency = new int[128];

        for (char c : tCharArray) {
            tFrequency[c]++;
        }

        while (rightIndex < sLen) {
            char c1 = sCharArray[rightIndex];

            if (tFrequency[c1] == 0) {
                rightIndex++;
                continue;
            }

            if (windowFrequency[c1] < tFrequency[c1]) {
                distance++;
            }

            windowFrequency[c1]++;

            while (distance == tLen) {
                if (rightIndex - leftIndex < minLength) {
                    begin = leftIndex;
                    minLength = rightIndex - leftIndex;
                }

                char c2 = sCharArray[leftIndex++];

                if (windowFrequency[c2] > 0) {
                    windowFrequency[c2]--;

                    if (windowFrequency[c2] < tFrequency[c2]) {
                        distance--;
                    }
                }
            }

            rightIndex++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(begin, begin + minLength + 1);
    }
}
