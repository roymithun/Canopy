package com.peto.canopy.algorithms.binary_search.roots;

import com.peto.canopy.utils.MathUtils;

public class CubicRoot {
    public static void main(String[] args) {
        System.out.println(findCubicRoot(125));
    }

    public static double findCubicRoot(double x) {
        double low = 0;
        double high = x;
        double precision = 0.0000001;

        while (true) {
            double mid = low + (high - low) / 2;
            double diff = MathUtils.abs(mid * mid * mid - x);
            if (diff <= precision) {
                return mid;
            } else if (mid * mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
    }
}
