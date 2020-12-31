package org.leetcode.easy;

import java.util.Arrays;

/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 */
public class Leetcode_283 {

    private static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    private static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (i == nums.length - 1) {
                break;
            }
            if (tmp == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // int[] input = new int[]{0, 1, 0, 3, 12};
        int[] input = new int[]{0, 0, 0, 0, 0, 0};
        moveZeroes(input);
        Arrays.stream(input).boxed().forEach(x -> System.out.printf("%s ", x));
    }
}
