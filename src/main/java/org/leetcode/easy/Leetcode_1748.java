package org.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
    1748. Sum of Unique Elements
*/
/*
    You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
    Return the sum of all the unique elements of nums.

    Example 1:
        Input: nums = [1,2,3,2]
        Output: 4
        Explanation: The unique elements are [1,3], and the sum is 4.

    Example 2:
        Input: nums = [1,1,1,1,1]
        Output: 0
        Explanation: There are no unique elements, and the sum is 0.

    Example 3:
        Input: nums = [1,2,3,4,5]
        Output: 15
        Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.

    Constraints:
        1 <= nums.length <= 100
        1 <= nums[i] <= 100
 */
public class Leetcode_1748 {

    private static int sumOfUnique(int[] nums) {

        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i], 1);
            } else{
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }

        }

        int sum = hmap.entrySet().stream().filter(entry -> {
            Integer vv = entry.getValue();
            return vv == 1;
        }).mapToInt(entry -> entry.getKey()).reduce(0, (acc, elem) -> {
            return acc + elem;
        });

        return sum;
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{ 1,2,3,2 };
        // int[] nums = new int[]{ 1,1,1,1,1 };
        int[] nums = new int[]{ 1,2,3,4,5 };
        System.out.println("ans = " + sumOfUnique(nums));
    }

}
