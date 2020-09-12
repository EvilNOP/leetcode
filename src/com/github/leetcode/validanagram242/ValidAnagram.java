package com.github.leetcode.validanagram242;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counter[c - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
