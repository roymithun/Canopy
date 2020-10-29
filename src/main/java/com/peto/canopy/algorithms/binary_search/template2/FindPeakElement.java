package com.peto.canopy.algorithms.binary_search.template2;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElementRecursive(new int[]{1, 2, 3, 4, 5, 1, 3, 5, 2, 3, 4, 5, 6}));
        System.out.println(findPeakElementRecursive(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findPeakElementRecursive(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(findPeakElementRecursive(new int[]{1}));
        System.out.println(findPeakElementRecursive(new int[]{3, 2, 1}));
        System.out.println(findPeakElementRecursive(new int[]{2, 1}));
    }

    public static int findPeakElementRecursive(int[] nums) {
        return recursiveSearch(nums, 0, nums.length - 1);
    }

    public static int recursiveSearch(int[] nums, int left, int right) {
        if (left == right)
            return left;
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[mid + 1])
            return recursiveSearch(nums, mid + 1, right);
        return recursiveSearch(nums, left, mid);
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
