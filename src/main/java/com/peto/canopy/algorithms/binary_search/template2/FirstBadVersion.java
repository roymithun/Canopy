package com.peto.canopy.algorithms.binary_search.template2;

public class FirstBadVersion {
    static int firstBadVersion = 3;

    public static void main(String[] args) {
        System.out.println(firstBadVersion(6));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
