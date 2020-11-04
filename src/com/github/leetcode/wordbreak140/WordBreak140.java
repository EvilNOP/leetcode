package com.github.leetcode.wordbreak140;

import java.util.*;

public class WordBreak140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<Integer, List<List<String>>> workBreaksByIndexes = new HashMap<>();
        List<List<String>> workBreaks = backtrack(s, words, 0, s.length(), workBreaksByIndexes);
        List<String> ans = new ArrayList<>();

        for (List<String> workBreak : workBreaks) {
            ans.add(String.join(" ", workBreak));
        }

        return ans;
    }

    public List<List<String>> backtrack(String s, Set<String> words, int start, int n, Map<Integer, List<List<String>>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<List<String>> wordBreaks = new LinkedList<>();

        if (start == n) {
            wordBreaks.add(new LinkedList<>());
        }

        for (int i = start; i < n; i++) {
            String word = s.substring(start, i + 1);

            if (words.contains(word)) {
                List<List<String>> subWordBreaks = backtrack(s, words, i + 1, n, map);

                for (List<String> subWordBreak : subWordBreaks) {
                    LinkedList<String> workBreak = new LinkedList<>(subWordBreak);
                    workBreak.offerFirst(word);
                    wordBreaks.add(workBreak);
                }
            }
        }

        map.put(start, wordBreaks);

        return wordBreaks;
    }
}
