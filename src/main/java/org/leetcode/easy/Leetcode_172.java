package org.leetcode.easy;

/*
    172. Factorial Trailing Zeroes
*/
/*
    Given an integer n, return the number of trailing zeroes in n!.
    Follow up: Could you write a solution that works in logarithmic time complexity?

    Example 1:
    Input: n = 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.

    Example 2:
    Input: n = 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.

    Example 3:
    Input: n = 0
    Output: 0

    Constraints:
    0 <= n <= 10^4
*/
public class Leetcode_172 {

    private static int factorial(int n){
        if (n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }

    private static int trailingZeroes(int n) {
        int num = factorial(n);

        int cc = 0;
        while (num / 10 != 0){

            if (num % 10 != 0){
                break;
            }

            if (num % 10 == 0){
                cc++;
            }
            num = num / 10;
        }

        return cc;
    }

    public static void main(String[] args) {

        System.out.println(factorial(7));
        System.out.println(factorial(12));
        System.out.println(factorial(13));

        System.out.println("ans = " + trailingZeroes(3));
        System.out.println("ans = " + trailingZeroes(5));
        System.out.println("ans = " + trailingZeroes(0));
        System.out.println("ans = " + trailingZeroes(7)); // 1
        System.out.println("ans = " + trailingZeroes(13)); // 2
    }
}
