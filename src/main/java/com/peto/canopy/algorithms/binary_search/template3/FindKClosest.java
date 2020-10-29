package com.peto.canopy.algorithms.binary_search.template3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosest {
    public static void main(String[] args) {
//        System.out.println(findClosestElements1(new int[]{1, 2, 3, 4, 5}, 4, 3));
//        System.out.println(findClosestElements1(new int[]{1, 2, 3, 4, 5}, 4, -1));
//        System.out.println(findClosestElements(new int[]{1, 2, 3, 5, 6, 7}, 4, 4));
//        System.out.println(findClosestElements1(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
        System.out.println(findClosestElements(new int[]{1, 3, 4, 5, 6, 7, 8}, 4, 2));

    }

    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = list.size();
        if (x <= list.get(0)) {
            return list.subList(0, k);
        } else if (list.get(n - 1) <= x) {
            return list.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(list, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(list.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if (low < 0 || (x - list.get(low)) <= (list.get(high) - x))
                    high--;
                else if (high > list.size() - 1 || (x - list.get(low)) > (list.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return list.subList(low, high + 1);
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        if (x <= arr[0]) {
            return Arrays.stream(arr).boxed().limit(k).collect(Collectors.toList());
        } else if (x >= arr[n - 1]) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(n - k - 1, n - 1);
        } else {
            int left = 0;
            int right = arr.length - 1;

            int mid = left + (right - left) / 2;
            System.out.printf("mid=%d | mid_prime=%d\n", mid, (left + right) >>> 1);

            if (arr[mid] == x) {
                int low = mid - k / 2 + 1;
            } else if (arr[mid] < x) {

            } else {

            }
        }

        return result;
    }
}
