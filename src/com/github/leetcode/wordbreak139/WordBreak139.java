package com.github.leetcode.wordbreak139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        int maxLen = 0;

        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && j >= i - maxLen; j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
