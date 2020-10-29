package com.peto.canopy.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(findPrimes(100));
    }
    public static ArrayList<Integer> findPrimes(int n) {
        boolean[] markingBoard = new boolean[n];
        Arrays.fill(markingBoard, true);
        markingBoard[0] = markingBoard[1] = false;
        for (int p = 2; p * p <= n; p++) {

            if (markingBoard[p]) {
                for (int i = p * p; i < n; i += p) {
                    markingBoard[i] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            if (markingBoard[x]) {
                result.add(x);
            }
        }
        return result;
    }

    public static boolean[] findPrimesMarking(int n) {
        boolean[] markingBoard = new boolean[n];
        Arrays.fill(markingBoard, true);
        markingBoard[0] = markingBoard[1] = false;
        for (int p = 2; p * p <= n; p++) {

            if (markingBoard[p]) {
                for (int i = p * p; i < n; i += p) {
                    markingBoard[i] = false;
                }
            }
        }
        return markingBoard;
    }
}
