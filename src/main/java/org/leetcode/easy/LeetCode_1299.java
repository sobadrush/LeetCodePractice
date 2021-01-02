package org.leetcode.easy;

import java.util.Arrays;

/*
    Given an array arr, replace every element in that array with the greatest element among the elements
    to its right, and replace the last element with -1.
    After doing so, return the array.

    Example 1:

    Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]
    Explanation:
    - index 0 --> the greatest element to the right of index 0 is index 1 (18).
    - index 1 --> the greatest element to the right of index 1 is index 4 (6).
    - index 2 --> the greatest element to the right of index 2 is index 4 (6).
    - index 3 --> the greatest element to the right of index 3 is index 4 (6).
    - index 4 --> the greatest element to the right of index 4 is index 5 (1).
    - index 5 --> there are no elements to the right of index 5, so we put -1.

    Example 2:

    Input: arr = [400]
    Output: [-1]
    Explanation: There are no elements to the right of index 0.

    Constraints:

    1 <= arr.length <= 104
    1 <= arr[i] <= 105
 */
public class LeetCode_1299 {

    private static int findMax(int[] arr, int beginIndex) {
        int max = arr[beginIndex + 1];
        for (int i = beginIndex + 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int[] replaceElements(int[] arr) {
        int[] rtnArr = new int[arr.length];
        if (arr.length == 1) {
            rtnArr[0] = -1;
            return rtnArr;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                rtnArr[i] = -1;
                break;
            }
            int maxRight = findMax(arr, i);
            // System.out.println("max = " + maxRight);
            rtnArr[i] = maxRight;
        }
        return rtnArr;
    }

    public static void main(String[] args) {
        int[] input = new int[]{17, 18, 5, 4, 6, 1};
        // int[] input = new int[]{400};
        int resultArr[] = replaceElements(input);
        // System.out.println(findMax(input, 0 ));
        Arrays.stream(resultArr).boxed().forEach(x -> System.out.printf("%s ", x));
    }
}
