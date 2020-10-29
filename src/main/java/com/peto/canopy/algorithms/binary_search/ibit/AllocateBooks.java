package com.peto.canopy.algorithms.binary_search.ibit;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
    public static void main(String[] args) {
        System.out.println(books(new ArrayList<>(Arrays.asList(12, 34, 67, 90)), 2)); // 113
//        System.out.println(books(new ArrayList<>(Arrays.asList(5, 17, 100, 11)), 4)); // 100

    }

    public static int books(ArrayList<Integer> A, int B) {
        long sum = 0;

        int n = A.size();

        // return -1 if no. of books is less than
        // no. of students
        if (n < B)
            return -1;

        // Count total number of pages
        for (Integer integer : A) {
            sum += integer;
        }
        // initialize start as 0 pages and end as
        // total pages
        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        // traverse until start <= end
        while (start <= end) {
            // check if it is possible to distribute
            // books by using mid is current minimum
            int mid = (start + end) / 2;
            if (isPossible(A, B, mid)) {
                // if yes then find the minimum distribution
                result = Math.min(result, mid);
                // as we are finding minimum and books
                // are sorted so reduce end = mid -1
                // that means
                end = mid - 1;
            } else {
                // if not possible means pages should be
                // increased so update start = mid + 1
                start = mid + 1;
            }
        }

        // at-last return minimum no. of  pages
        return result;
    }

    // Utility method to check if current minimum value
    // is feasible or not.
    static boolean isPossible(ArrayList<Integer> A, int B, int currMin) {
        int studentsRequired = 1;
        int currSum = 0;
        int n = A.size();

        // iterate over all books
        for (Integer integer : A) {
            // check if current number of pages are greater
            // than currMin that means we will get the result
            // after mid no. of pages
            if (integer > currMin)
                return false;

            // count how many students are required
            // to distribute currMin pages
            if (currSum + integer > currMin) {
                // increment student count
                studentsRequired++;
                // update currSum
                currSum = integer;

                // if students required becomes greater
                // than given no. of students,return false
                if (studentsRequired > B) {
                    return false;
                }
            }
            // else update currSum
            else {
                currSum += integer;
            }
        }
        return true;
    }
}
