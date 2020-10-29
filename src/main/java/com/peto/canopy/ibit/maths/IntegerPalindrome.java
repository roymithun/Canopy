package com.peto.canopy.ibit.maths;

public class IntegerPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(1000000003));
    }

    public static int isPalindrome1(int num) {
        int reverted = 0;
        while (num > 0) {
            reverted = reverted * 10 + num % 10;
            num /= 10;
        }

        return num == reverted ? 1 : 0;
    }

    public static int isPalindrome(int A) {
        if (A < 0)
            return 0;
        if (A < 10)
            return 1;

        StringBuilder s = new StringBuilder();
        s.append(A);
        s.reverse();
        if (s.toString().equals("" + A))
            return 1;
        return 0;
    }
}
