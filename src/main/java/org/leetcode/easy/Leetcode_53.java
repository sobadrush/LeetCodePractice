package org.leetcode.easy;

/*
    53. Maximum Subarray
*/
/*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/
/*
    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Example 2:
    Input: nums = [1]
    Output: 1

    Example 3:
    Input: nums = [0]
    Output: 0

    Example 4:
    Input: nums = [-1]
    Output: -1

    Example 5:
    Input: nums = [-100000]
    Output: -100000
 */
public class Leetcode_53 {
    /**
     * Kadane’s Algorithm
     * ref. https://zhuanlan.zhihu.com/p/96014673
     */
    private static int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int absMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            System.out.println("localMax = " + localMax);
            absMax = Math.max(absMax, localMax);
        }
        return absMax;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[]{ -2,1,-3,4,-1,2,1,-5,4 };
        System.out.println("ans = " + maxSubArray(inputArr));
    }
}
