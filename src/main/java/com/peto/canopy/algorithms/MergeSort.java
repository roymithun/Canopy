package com.peto.canopy.algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] candidate = new Integer[]{8, 5, 2, 4, 2, 3, 1, 2, 1, 11, 9, 23, 1, 13};
        Integer[] candidateCopy = new Integer[candidate.length];

        sort(candidate, candidateCopy, 0, candidate.length - 1);
        Arrays.stream(candidate).forEach(System.out::println);
    }

    private static void sort(Integer[] a, Integer[] aCopy, int low, int high) {
        if (high <= low) {
            // termination of recursion
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, aCopy, low, mid);
        sort(a, aCopy, mid + 1, high);
        merge(a, aCopy, low, mid, high);
    }

    private static void merge(Integer[] a, Integer[] aCopy, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aCopy[k] = a[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aCopy[j++];
            } else if (j > high) {
                a[k] = aCopy[i++];
            } else if (aCopy[j] < aCopy[i]) {
                a[k] = aCopy[j++];
            } else {
                a[k] = aCopy[i++];
            }
        }
    }

    public static <T> void applySort(LinkedList<T> linkedList) {

    }
}
