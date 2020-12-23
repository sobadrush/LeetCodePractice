package org.leetcode.easy;

public class LeetCode_342 {

    private static boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n == 1) return true;

        if (n % 4 != 0) {
            return false;
        }
        if (n % 4 == 0 && n == 4) return true;
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {
        System.out.println("ans1 = " + isPowerOfFour(16));
        System.out.println("ans2 = " + isPowerOfFour(5));
        System.out.println("ans3 = " + isPowerOfFour(1));
    }
}
