package com.peto.canopy.algorithms.binary_search.template1;

public class SearchRotatedArray {
    public static void main(String[] args) {
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
//        System.out.println(search(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 8));
//        System.out.println(search(new int[]{5, 1, 2, 3, 4}, 1));
//        System.out.println(search(new int[]{5, 1, 3}, 5));
//        System.out.println(search(new int[]{0, 1, 2, 4, 5, 6, 7}, 4));
//        System.out.println(search(new int[]{8, 1, 3, 4, 6}, 4));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2, 3},    4));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (target == midVal) {
                return mid;
            } else if (leftVal <= midVal) {
                if (leftVal <= target && target < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (midVal < target && target <= rightVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
