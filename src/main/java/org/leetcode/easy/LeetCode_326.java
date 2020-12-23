package org.leetcode.easy;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three, if there exists an integer x such that n == 3x
 */
public class LeetCode_326 {

    public static boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n % 3 != 0) {
            return false;
        }
        if (n % 3 == 0 && n == 3) return true;
        return isPowerOfThree(n / 3);
    }

    // public static boolean isPowerOfThree(int n) {
    //
    //     int i = 0;
    //     while(Math.pow(3, i) <= n){
    //         if (Math.pow(3, i) == n){
    //             return true;
    //         }
    //         i++;
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        System.out.println("ans1 = " + isPowerOfThree(27));
        System.out.println("ans2 = " + isPowerOfThree(0));
        System.out.println("ans3 = " + isPowerOfThree(9));
        System.out.println("ans4 = " + isPowerOfThree(45));
    }
}
