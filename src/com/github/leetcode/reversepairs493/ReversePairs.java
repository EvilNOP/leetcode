package com.github.leetcode.reversepairs493;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1, new int[nums.length]);
    }

    public int reversePairs(int[] nums, int low, int high, int[] aux) {
        if (low < high) {
            int mid = (low + high) / 2;

            int leftReversePairs = reversePairs(nums, low, mid, aux);
            int rightReversePairs = reversePairs(nums, mid + 1, high, aux);
            int crossReversePairs = mergeAndCount(nums, low, mid, high, aux);

            return leftReversePairs + crossReversePairs + rightReversePairs;
        }

        return 0;
    }

    public int mergeAndCount(int[] nums, int low, int mid, int high, int[] aux) {
        int i = low;
        int j = mid + 1;

        if (high + 1 - low >= 0) System.arraycopy(nums, low, aux, low, high + 1 - low);

        int reversePairsCount = 0;

        while (i <= mid) {
            while (j <= high && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }

            reversePairsCount += j - mid - 1;
            i++;
        }

        i = low;
        j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > high) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }

        return reversePairsCount;
    }
}
