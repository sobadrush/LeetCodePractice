package org.leetcode.easy;

/*
    [Medium] 560. Subarray Sum Equals K
 */
/*
    Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 */
/*
    Example 1:
        Input: nums = [1,1,1], k = 2
        Output: 2
    Example 2:
        Input: nums = [1,2,3], k = 3
        Output: 2
    Constraints:
         1 <= nums.length <= 2 * 10^4
        -1000 <= nums[i] <= 1000
        -10^7 <= k <= 10^7
 */
public class Leetcode_560 {

    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            int j = i;
            while (j < nums.length){
                sum += nums[j++];
                if (sum == k) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{ 1, 1, 1 };
        int ans = subarraySum(nums, k);
        System.out.println("ans = " + ans);
    }
}
