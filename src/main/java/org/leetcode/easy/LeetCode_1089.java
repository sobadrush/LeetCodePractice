package org.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
    Note that elements beyond the length of the original array are not written.
    Do the above modifications to the input array in place, do not return anything from your function.

    Example 1:

    Input: [1,0,2,3,0,4,5,0]
    Output: null
    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

    Example 2:

    Input: [1,2,3]
    Output: null
    Explanation: After calling your function, the input array is modified to: [1,2,3]


    Note:

    1 <= arr.length <= 10000
    0 <= arr[i] <= 9
 */
public class LeetCode_1089 {

    public static void duplicateZeros(int[] arr) {
        List<Integer> mylist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                mylist.add(arr[i]);
            } else {
                mylist.add(0);
                mylist.add(0);
            }
        }

        Integer[] resultArr = mylist.toArray(new Integer[]{});
        final AtomicInteger idx = new AtomicInteger(0);
        Arrays.stream(resultArr).forEach(x -> {
            if (idx.get() < arr.length) {
                arr[idx.get()] = x;
            }
            idx.incrementAndGet();
        });

    }

    public static void main(String[] args) {
        int[] input = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(input);
        Arrays.stream(input).boxed().forEach(x -> {
            System.out.printf(" %s ", x);
        });
    }
}
