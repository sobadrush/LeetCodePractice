package org.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]


    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:
    2 <= nums.length <= 103
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */
public class Leetcode_001 {

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int theNum = nums[i];
            int numToFind = target - theNum;

            if (hmap.get(numToFind) != null && i == hmap.get(numToFind)) {
                continue;
            }
            if (hmap.get(numToFind) != null && i != hmap.get(numToFind)) {
                return new int[]{ i, hmap.get(numToFind) };
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = { 3,3 };
        int target = 6;

        int[] ansArr = twoSum(nums, target);

        IntStream.range(0, ansArr.length).mapToObj(i -> {
            return ansArr[i];
        }).forEach(x -> System.out.printf("%s ", x));
    }
}
