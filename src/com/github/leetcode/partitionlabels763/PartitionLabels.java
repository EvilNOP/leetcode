package com.github.leetcode.partitionlabels763;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        char[] sCharArray = S.toCharArray();
        List<Integer> ans = new ArrayList<>();

        int[] last = new int[26];

        for (int i = 0; i < sCharArray.length; i++) {
            last[sCharArray[i] - 'a'] = i;
        }

        int i = 0;
        int j = 0;

        for (int index = 0; index < len; index++) {
            j = Math.max(j, last[sCharArray[index] - 'a']);

            if (index == j) {
                ans.add(j - i + 1);
                i = j + 1;
            }
        }

        return ans;
    }
}
