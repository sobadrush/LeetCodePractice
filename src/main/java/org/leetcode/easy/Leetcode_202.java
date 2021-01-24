package org.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Write an algorithm to determine if a number is "happy".
    A happy number is a number defined by the following process: Starting with any positive integer,
    replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
    (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy numbers.

    Example: 19 is a happy number
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

    Example 2:
    Input: n = 2
    Output: false

 */
public class Leetcode_202 {

    private static Set<Integer> HSET = new HashSet<Integer>();

    private static boolean isHappy(int n) {

        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            int digitSquare = (int) Math.pow(digit, 2);
            sum += digitSquare;
            n = n / 10;
        }

        if (HSET.contains(sum)) return false;

        if (sum == 1) {
            return true;
        }

        HSET.add(sum);

        return isHappy(sum);
    }

    public static void main(String[] args) {
        int nn = 19;
        // int nn = 2;
        // int nn = 1;
        // int nn = 7;
        System.out.println(isHappy(nn));
        // getPerNum(197).stream().forEach(System.out::println);
    }

}
