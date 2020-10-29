package com.peto.canopy.utils;

public class StringUtils {
    public static String removeLeadingZeroes(String s) {
        return s.replaceAll("^0+", "");
    }

    public static String removeTrailingZeroes(String s) {
        return s.replaceAll("0+$", "");
    }
}
