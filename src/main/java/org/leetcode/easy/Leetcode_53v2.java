package org.leetcode.easy;

/*
    53. Maximum Subarray
 */
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class Leetcode_53v2 {

    public static int maxSubArray(int[] nums) {

        int absMaxSum = nums[0];
        int localSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (localSum + nums[i] < nums[i]){
                localSum = nums[i];
            } else{
                localSum += nums[i];
            }
            absMaxSum = Math.max(localSum, absMaxSum);
        }
        return absMaxSum;
    }

    public static void main(String[] args) {
        /*
            Example 1:
                Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
                Output: 6
                Explanation: [4,-1,2,1] has the largest sum = 6.
         */

        int[] arr = new int[]{ -2,1,-3,4,-1,2,1,-5,4 };
        // int[] arr = new int[]{ 1 };
        int ans = maxSubArray(arr);
        System.out.println("ans = " + ans);
    }
}
