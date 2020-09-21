package com.github.leetcode.subarraysum560;

import java.util.HashMap;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int preSum = 0;

        HashMap<Integer, Integer> preSumFrequencies = new HashMap<>();
        preSumFrequencies.put(0, 1);

        int count = 0;

        for (int num : nums) {
            preSum += num;

            if (preSumFrequencies.containsKey(preSum - k)) {
                count += preSumFrequencies.get(preSum - k);
            }

            preSumFrequencies.put(preSum, preSumFrequencies.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
