package com.peto.canopy.algorithms.binary_search.roots;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }

    public static int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A;
        }
        int low = 1;
        int high = A / 2;

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == A / mid) {
                return mid;
            } else if (mid < A / mid) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
