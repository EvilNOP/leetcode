package com.github.leetcode.findallanagrams483;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        List<Integer> ans = new ArrayList<>();

        if (sLen == 0 || pLen == 0 || sLen < pLen) {
            return ans;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int distance = 0;

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        int[] pFrequency = new int[128];
        int[] windowFrequency = new int[128];

        for (char c : pCharArray) {
            pFrequency[c]++;
        }

        while (rightIndex < sLen) {
            char c1 = sCharArray[rightIndex];

            if (pFrequency[c1] == 0) {
                rightIndex++;
                continue;
            }

            if (windowFrequency[c1] < pFrequency[c1]) {
                distance++;
            }

            windowFrequency[c1]++;

            while (distance == pLen) {
                if (rightIndex - leftIndex < pLen) {
                    ans.add(leftIndex);
                }

                char c2 = sCharArray[leftIndex++];

                if (windowFrequency[c2] > 0) {
                    windowFrequency[c2]--;

                    if (windowFrequency[c2] < pFrequency[c2]) {
                        distance--;
                    }
                }
            }

            rightIndex++;
        }

        return ans;
    }
}
