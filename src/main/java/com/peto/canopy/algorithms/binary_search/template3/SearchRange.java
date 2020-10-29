package com.peto.canopy.algorithms.binary_search.template3;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }

    public static int binarySearch(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;

        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (first)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }
}
