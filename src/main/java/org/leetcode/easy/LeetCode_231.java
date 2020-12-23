package org.leetcode.easy;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

/**
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: false
 * Example 4:
 * <p>
 * Input: n = 4
 * Output: true
 */
public class LeetCode_231 {

    static int times = 1;

    public static boolean isEven(int num) {
        return num % 2 == 1 ? false : true;
    }

    public static boolean isPowerOfTwo(int n) {

        if (n == 1) {
            return true;
        }
        if (!isEven(n)) {
            return false;
        }

        int jj = 0;
        do {
            if(Math.pow(2, jj) == n)
                return true;
            jj++;
        } while(Math.pow(2, jj) <= n);
        return false;

        // int i = 0;
        // while (Math.pow(2, i) <= n){
        //     if(Math.pow(2, i) == n){
        //         return true;
        //     }
        //     i++;
        // }
        // return false;

        // 遞迴解
        // --------------------------------
        // if (n == 1) {
        //     return true;
        // }
        // if (!isEven(n)) {
        //     return false;
        // }
        //
        // times++;
        // if (n == 2) {
        //     return true;
        // }
        //
        // return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        System.out.println("ans1 = " + isPowerOfTwo(1));
        System.out.println("ans2 = " + isPowerOfTwo(16));
        System.out.println("ans3 = " + isPowerOfTwo(3));
        System.out.println("ans4 = " + isPowerOfTwo(4));
        System.out.println("ans5 = " + isPowerOfTwo(5));
    }
}
