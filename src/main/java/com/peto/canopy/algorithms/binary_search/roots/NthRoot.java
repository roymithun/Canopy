package com.peto.canopy.algorithms.binary_search.roots;

import com.peto.canopy.utils.MathUtils;

public class NthRoot {
    public static void main(String[] args) {
        System.out.println(findNthRealRoot(9, 2));
    }

    public static double findNthRealRoot(double x, int n) {
        double low;
        double high;
        if (x >= 0 && x <= 1) {
            low = x;
            high = 1;
        } else {
            low = 0;
            high = x;
        }
        double precision = 0.00000001;
        double guess;

        do {
            guess = low + (high - low) / 2;
            if (Math.pow(guess, n) > x) {
                high = guess;
            } else {
                low = guess;
            }
        } while (MathUtils.abs(Math.pow(guess, n) - x) >= precision);
        return guess;
    }
}
