package com.github.leetcode.offer.inversions51;

public class Inversions {

    public int mergeSort(int[] arr, int low, int high, int[] aux) {
        if (low < high) {
            int middle = (high + low) / 2;

            int leftInversions = mergeSort(arr, low, middle, aux);
            int rightInversions = mergeSort(arr, middle + 1, high, aux);
            int crossInversions = mergeAndCount(arr, low, middle, high, aux);

            return leftInversions + crossInversions + rightInversions;
        }

        return 0;
    }

    public int mergeAndCount(int[] arr, int low, int mid, int high, int[] aux) {
        int i = low;
        int j = mid + 1;

        if (high + 1 - low >= 0) System.arraycopy(arr, low, aux, low, high + 1 - low);

        int inversions = 0;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > high) {
                arr[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                inversions += (mid - i + 1);
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }

        return inversions;
    }

    public int reversePairs(int[] nums) {
        int[] aux = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, aux);
    }
}
