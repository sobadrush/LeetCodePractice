package org.leetcode.easy;

import java.util.*;

/*
    283. Move Zeroes
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
public class Leetcode_283v3 {

    private static void moveZeroes(int[] nums) {
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                indexQueue.offer(nums[i]);
            }
        }
        // indexQueue.stream().forEach(elem -> System.out.println(elem));

        int len = indexQueue.size() - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i <= len) {
                nums[i] = indexQueue.poll();
            } else{
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 0,1,0,3,12 };
        moveZeroes(arr);
        Arrays.stream(arr).forEach(elem -> {
            System.out.println(elem);
        });
    }
}
