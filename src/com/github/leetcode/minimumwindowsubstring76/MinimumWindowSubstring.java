package com.github.leetcode.minimumwindowsubstring76;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int leftIndex = 0;
        int rightIndex = 0;
        int minWindowLeftIndex = 0;
        int minLength = Integer.MAX_VALUE;
        int matchesCount = 0;
        int sLen = s.length();

        HashMap<Character, Integer> targetCharsCount = new HashMap<>();
        HashMap<Character, Integer> windowCharsCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            targetCharsCount.put(t.charAt(i), targetCharsCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (rightIndex < sLen) {
            char c1 = s.charAt(rightIndex);

            if (targetCharsCount.get(c1) != null) {
                int count = windowCharsCount.getOrDefault(c1, 0) + 1;
                windowCharsCount.put(c1, count);

                if (count == targetCharsCount.get(c1)) {
                    matchesCount++;
                }
            }

            while (matchesCount == targetCharsCount.size()) {
                if (rightIndex - leftIndex < minLength) {
                    minWindowLeftIndex = leftIndex;
                    minLength = rightIndex - leftIndex;
                }

                char c2 = s.charAt(leftIndex);

                if (windowCharsCount.get(c2) != null) {
                    int count = windowCharsCount.get(c2) - 1;
                    windowCharsCount.put(c2, count);

                    if (count < targetCharsCount.get(c2)) {
                        matchesCount--;
                    }
                }

                leftIndex++;
            }

            rightIndex++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minWindowLeftIndex, minWindowLeftIndex + minLength + 1);
    }
}
