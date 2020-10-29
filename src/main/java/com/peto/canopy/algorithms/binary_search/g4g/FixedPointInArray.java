package com.peto.canopy.algorithms.binary_search.g4g;

import java.util.ArrayList;
import java.util.Arrays;

public class FixedPointInArray {
    public static void main(String[] args) {
        System.out.println(findFixedPoint(new ArrayList<>(Arrays.asList(-10, -5, 0, 3, 7))));
        System.out.println(findFixedPoint(new ArrayList<>(Arrays.asList(0, 2, 5, 8, 17))));
        System.out.println(findFixedPoint(new ArrayList<>(Arrays.asList(-10, -5, 3, 4, 7, 9))));
        System.out.println(findFixedPoint(new ArrayList<>(Arrays.asList(-10, -1, 0, 3, 10, 11, 30, 50, 100))));
    }

    public static int findFixedPoint(ArrayList<Integer> a) {
//        return linearSearch(a);
        return binarySearch(a);
    }

    static int linearSearch(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i);
            if (x < 0)
                continue;
            if (x == i)
                return i;
        }
        return -1;
    }

    static int binarySearch(ArrayList<Integer> a) {
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = a.get(mid);
            if (val == mid) {
                return mid;
            } else if (val > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
