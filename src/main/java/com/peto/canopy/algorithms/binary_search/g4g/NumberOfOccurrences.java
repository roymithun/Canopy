package com.peto.canopy.algorithms.binary_search.g4g;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfOccurrences {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8));
        System.out.println(countOccurrences(a, 2));
    }

    public static int countOccurrences(ArrayList<Integer> a, int x) {
        int firstIdx = binarySearch(a, x, true);
        if (firstIdx == -1) {
            return 0;
        } else {
            int lastIdx = binarySearch(a, x, false);
            return lastIdx - firstIdx + 1;
        }
    }

    public static int binarySearch(ArrayList<Integer> a, int x, boolean isFirst) {
        int n = a.size();
        int low = 0;
        int high = n - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = a.get(mid);
            if (midVal == x) {
                result = mid;
                if (isFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (midVal < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
