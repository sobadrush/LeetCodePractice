package org.leetcode.easy;

import java.util.Arrays;

/*
    628. Maximum Product of Three Numbers
 */
/*
    Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

    Example 1:
        Input: nums = [1,2,3]
        Output: 6

    Example 2:
        Input: nums = [1,2,3,4]
        Output: 24

    Example 3:
        Input: nums = [-1,-2,-3]
        Output: -6
    Constraints:
        3 <= nums.length <= 10^4
        -1000 <= nums[i] <= 1000
 */
public class Leetcode_628 {

    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int porductResultLeft = 1;
        for (int i = 0; i < 2; i++) {
            porductResultLeft *= nums[i];
        }

        if(porductResultLeft > 0){
            porductResultLeft *= nums[nums.length - 1];
        } else{
            porductResultLeft *= nums[2];
        }

        // System.out.println(porductResultLeft);
        int porductResultRight = 1;
        for (int i = nums.length - 1 ; i > nums.length - 4; i--) {
            porductResultRight *= nums[i];
        }
        // System.out.println(porductResultRight);
        return Math.max(porductResultLeft, porductResultRight);
    }

    public static void main(String[] args) {
        // Example 1:
        // Input: nums = [1,2,3]
        // Output: 6
        // int[] arr = new int[]{ 1, 2, 3 };
        // int[] arr = new int[]{ -3, -2, -1 ,3, 5, 6 };
        int[] arr = new int[]{ -100,-98,-1,2,3,4 };
        System.out.println("ans = " + maximumProduct(arr));
    }
}
