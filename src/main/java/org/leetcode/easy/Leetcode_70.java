package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
    70. Climbing Stairs
 */
/*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
/*
    Example 1:
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

    Example 2:
        Input: n = 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step

    Constraints:
        1 <= n <= 45
 */
public class Leetcode_70 {

    /*
        n = 1 :  1

        n = 2 :  2

        n = 3 :  3

        n = 4 : 2 + 3 = 5 → n(2) + n(3) = 5
            1 1 1 1
            2 2
            1 2 1
            1 1 2
            2 1 1
     */
    private static int climbStairs(int n) { // 效能太差: Time Limit Exceeded
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    private static int climbStairs_Iterator(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;

        List<Integer> rList = new ArrayList<Integer>() {
            {
                super.add(1);
                super.add(2);
            }
        };

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2){
                continue;
            }
            int tempSum = 0;
            tempSum += rList.get(i-1 -1) + rList.get(i-2 -1);
            rList.add(tempSum);
            // System.out.println(tempSum);
        }

        return rList.get(rList.size() - 1);
    }

    private static int climbStairs_Iterator2(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;

        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        //System.out.println("third = " + third);
        return third;
    }

    public static void main(String[] args) {
        // System.out.println("ans = " + climbStairs(3));
        // System.out.println("ans = " + climbStairs(4));
        // System.out.println("ans = " + climbStairs(45));

        // System.out.println("ans Iterator = " + climbStairs_Iterator(3));
        // System.out.println("ans Iterator = " + climbStairs_Iterator(4));
        // System.out.println("ans Iterator = " + climbStairs_Iterator(45));

        System.out.println("ans Iterator2 = " + climbStairs_Iterator2(3));
        System.out.println("ans Iterator2 = " + climbStairs_Iterator2(4));
        System.out.println("ans Iterator2 = " + climbStairs_Iterator2(45));
    }

}
