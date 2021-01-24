package org.leetcode.easy;

/**
 * 204. Count Primes
 */
/*
    Count the number of prime numbers less than a non-negative number, n.
 */
/*
    Example 1:

    Input: n = 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

    Example 2:

    Input: n = 0
    Output: 0

    Example 3:

    Input: n = 1
    Output: 0


    Constraints:

    0 <= n <= 5 * 106
 */

/**
 * 參考解法: https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/204md.html
 */
public class Leetcode_204 {

    private static boolean isPrime(int n){
        switch ( n % 2 ) {
            case 0:
                if ( n == 2 ) return true;
                return false;
            default:
                if ( n == 1 ) return true;

                int aa = 3;
                while( aa <= (Math.sqrt(n)) ){
                    if ( n % aa == 0 ) return false;
                    aa += 2;
                }
                return true;
        }
    }

    private static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if ( isPrime(i) ){
                System.out.println( i + ": isPrime = " + isPrime(i));
                if (i == 1) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println("ans = " + countPrimes(10));
        // for (int i = 1; i < 24; i++) {
        //     System.out.println( i + ": isPrime = " + isPrime(i));
        // }
        // System.out.println("ans = " + countPrimes(10));
        // System.out.println("ans = " + countPrimes(0));
        // System.out.println("ans = " + countPrimes(1));
        System.out.println("ans = " + countPrimes(499979));
    }

}
