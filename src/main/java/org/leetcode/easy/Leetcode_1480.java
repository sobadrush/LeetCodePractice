package org.leetcode.easy;

import java.util.Arrays;

/*
    1480. Running Sum of 1d Array
 */
/*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
 */
/*
    Example 1:
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

    Example 2:
    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

    Example 3:
    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]


    Constraints:
    1 <= nums.length <= 1000
    -10^6 <= nums[i] <= 10^6
 */
public class Leetcode_1480 {

    private static int[] runningSum(int[] nums) {
        int[] numsCopy = nums.clone();
        for (int i = 0; i < numsCopy.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += numsCopy[j];
            }
            // System.out.println(sum);
            nums[i] = sum;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = runningSum(new int[]{ 1, 2, 3, 4 }); // [1,3,6,10]
        Arrays.stream(arr).forEach(elem -> {
            System.out.println(elem);
        });
    }
}
