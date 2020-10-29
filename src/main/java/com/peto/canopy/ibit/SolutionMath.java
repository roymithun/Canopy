package com.peto.canopy.ibit;

import com.peto.canopy.utils.SieveOfEratosthenes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SolutionMath {
    public static void main(String[] args) {
        testSmallestNumberFactorial();
    }

    private static void testSmallestNumberFactorial() {
        System.out.println(factorial(findNum(7)));
    }

    // Smallest number with at least n trailing zeroes in factorial
    private static int findNum(int n) {
//        https://www.geeksforgeeks.org/smallest-number-least-n-trailing-zeroes-factorial/
        if (n == 1) {
            return 5;
        }

        // binary search from 0 -> 5*n
        int low = 0;
        int high = 5 * n;

        while (low < high) {
            int mid = (low + high) >> 1;
            // Checking if mid's factorial
            // contains n trailing zeroes.
            if (check(mid, n))
                high = mid;
            else
                low = mid + 1;
        }
        System.out.println("low = " + low);
        return low;
    }

    // Return true if number's factorial contains
    // at least n trailing zero else false.
    private static boolean check(int p, int n) {
        int count = 0;
        for (int i = 5; p / i >= 1; i *= 5) {
            count += p / i;
        }

        return count >= n;
    }

    private static void testTrailingZeroes() {
//        System.out.println(trailingZeroes(9247));
//        System.out.println(trailingZeroes(6410));
        System.out.println(trailingZeroes(125));
    }

    private static int trailingZeroes(int A) {
//        https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
        // Initialize result
        int count = 0;

        // Keep dividing n by powers
        // of 5 and update count
        for (int i = 5; A / i >= 1; i *= 5) {
            count += A / i;
        }

        return count;
    }

    static BigInteger factorial(int n) {
        if (n == 1 || n == 0)
            return BigInteger.ONE;
        else
            return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    private static void testReverseInteger() {
        System.out.println(reverseInteger(21));
    }

    private static int reverseInteger(int A) {
        boolean isNegative = A < 0;
        String s = String.valueOf(A);
        StringBuilder sb = new StringBuilder(s);
        if (isNegative) {
            sb.deleteCharAt(0);
        }
        sb.reverse();
        long l = Long.parseLong(sb.toString());
        if (l >= Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? -l : l);
    }

    private static void testIsPower() {
        System.out.println(isPower(1));
    }

    private static int isPower(int A) {
        if (A == 1) {
            return 1;
        }
        long n = A;
        System.out.println(n);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            long p = i;
            while (p <= n) {
                p = p * i;
                if (p == A) {
                    return 1;
                }
            }
        }
        return 0;
    }
    /*private static int isPower(int A) {
        for (int i = 2; i <= Math.sqrt(A); i++) {
            int p = i;
            int limit = (int) Math.pow(Integer.MAX_VALUE, i);
            while (p <= limit) {
                p = p * i;
                if (p == A) {
                    return 1;
                }
            }
        }
        return 0;
    }*/

    private static void testFindDigitsInBinary() {
        System.out.println(findDigitsInBinary(6));
    }

    public static String findDigitsInBinary(int A) {
        if (A == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int n = A;
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    private static void testAllFactors() {
        System.out.println(allFactors(36));
    }

    private static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                result.add(i);
                if (i != A / i) {
                    result.add(A / i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    private static void testPrimeSum() {
        System.out.println(primesum(4));
    }

    private static ArrayList<Integer> primesum(int A) {
        boolean[] primesMarking = SieveOfEratosthenes.findPrimesMarking(A);
        int n = primesMarking.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (primesMarking[i] && primesMarking[n - i]) {
                result.add(new ArrayList<>(Arrays.asList(i, n - i)));
            }
        }
        return result.isEmpty() ? new ArrayList<>() : result.get(0);
    }
}
