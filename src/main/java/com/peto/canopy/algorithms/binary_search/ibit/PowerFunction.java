package com.peto.canopy.algorithms.binary_search.ibit;

import java.math.BigInteger;

public class PowerFunction {
    public static void main(String[] args) {
//        System.out.println(pow(79161127, 99046373, 57263970)); //47168647
//        System.out.println(pow(71045970, 41535484, 64735492)); // 20805472

//        System.out.println(pow1(71045970, 41535484, 64735492)); // 20805472
        System.out.println(pow1(-1, 1, 20)); // 19

//        System.out.println(findPow(3, 7, 5));

//        System.out.println(expBySquaring(79161127, 99046373));

//        System.out.println(findPow(79161127, 99046373, 57263970));
//        System.out.println(findPow(71045970, 41535484, 64735492));
    }

    // https://en.wikipedia.org/wiki/Modular_exponentiation#Right-to-left_binary_method
    public static int pow1(int x, int n, int d) {
        long base = x;
        if (d == 1)
            return 0;
        long result = 1;
        base = base % d;
        while (n > 0) {
            if (n % 2 == 1)
                result = (result * base) % d;
            n = n >> 1;
            base = (base * base) % d;
        }
        return (int) (result < 0 ? d + result : result);
    }

    public static int pow2(int x, int n, int d) {
        BigInteger base = BigInteger.valueOf(x);
        BigInteger modulus = BigInteger.valueOf(d);
        if (d == 1)
            return 0;
        BigInteger result = BigInteger.ONE;
        base = base.mod(modulus);
        while (n > 0) {
            if (n % 2 == 1)
                result = result.multiply(base).mod(modulus);
            n = n >> 1;
            base = (base.multiply(base)).mod(modulus);
        }
        return result.intValue();
    }

    public static BigInteger expBySquaring(BigInteger x, int n) {
        if (n == 0) return BigInteger.ONE;
        if (n == 1) return x;
        if (n % 2 == 0)
            return expBySquaring(x.multiply(x), n / 2);
        else
            return x.multiply(expBySquaring(x.multiply(x), (n - 1) / 2));
    }

    public static BigInteger expBySquaring(int x, int n) {
        if (n == 0) return BigInteger.ONE;
        if (n == 1) return BigInteger.valueOf(x);
        if (n % 2 == 0)
            return expBySquaring(x * x, n / 2);
        else
            return BigInteger.valueOf(x).multiply(expBySquaring(x * x, (n - 1) / 2));
    }
   /* public static BigInteger recursivePow(int x, int n) {
        BigInteger temp;
        if (n == 0) {
            return BigInteger.ONE;
        }
        temp = recursivePow(x, n / 2);
        if (n % 2 == 0)
            return temp.multiply(temp);
        else
            return BigInteger.valueOf(x).multiply(temp).multiply(temp);
    }*/

    /*x^15 = (x^7)*(x^7)*x
    x^7 = (x^3)*(x^3)*x
    x^3 = x*x*x*/

    public static int pow(int x, int n, int d) {
        long ans = 1;
        if (x == 0 && n == 0) {
            if (d != 1)
                return 1;
            else
                return 0;
        }
        if (x == 0)
            return 0;
        long a = x;
        int b = n;

        while (b > 0) {
            if ((b & 1) == 1)
                ans = (ans * a);
            if (ans < 0)
                ans = d - (-1 * x) % d;
            else
                ans = ans % d;

            b = b >> 1;
            a = (a * a) % d;
        }

        return (int) ans;
    }
}

