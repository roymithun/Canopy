package com.peto.canopy.justdoit;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 7, 6}, 9)));
    }

    public static int[] twoSum(int[] input, int target) {
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            if (values.containsKey(complement)) {
                return new int[]{values.get(complement), i};
            }
            values.put(input[i], i);
        }
        return null;
    }
}
