package org.leetcode.easy;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 */
/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Note:
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 */
public class Leetcode_283_v2 {
    private static void moveZeroes(int[] nums) {

        if (nums.length == 1){
            return;
        }

        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                countZero++;
                continue;
            }

            if (countZero != 0){
                nums[i - countZero] = nums[i];
                nums[i] = 0;
            }

        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{ 0,1,0,3,12 };
        // int[] input = new int[]{ 1 };
        // int[] input = new int[]{ 1, 0 };
        moveZeroes(input);
        Arrays.stream(input).boxed().forEach(x -> System.out.printf("%s ", x));
    }
}
