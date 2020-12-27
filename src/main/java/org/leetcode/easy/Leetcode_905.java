package org.leetcode.easy;

import java.util.*;

/**
 * Given an array A of non-negative integers,
 * return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 */

/*
    Example 1:
    Input: [3,1,2,4]
    Output: [2,4,3,1]
    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

    Note:
    1 <= A.length <= 5000
    0 <= A[i] <= 5000
 */
public class Leetcode_905 {

    public static int[] sortArrayByParity(int[] A) {
        Map<String, List<Integer>> hmap = new HashMap<>();
        hmap.put("odd", new ArrayList<Integer>());
        hmap.put("even", new ArrayList<Integer>());
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                hmap.get("even").add(A[i]);
            } else {
                hmap.get("odd").add(A[i]);
            }
        }

        // for (String kk : hmap.keySet()) {
        //     System.out.println(kk + " - " + hmap.get(kk));
        // }

        int[] arrEven = hmap.get("even").stream().mapToInt(x -> x).toArray();
        int[] arrOdd = hmap.get("odd").stream().mapToInt(x -> x).toArray();

        int[] resultArr = new int[arrEven.length + arrOdd.length];
        System.arraycopy(arrEven, 0, resultArr, 0, arrEven.length);
        System.arraycopy(arrOdd, 0, resultArr, arrEven.length, arrOdd.length);

        return resultArr;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 2, 4};
        Arrays.stream(sortArrayByParity(input)).forEach(x -> System.out.printf("%s ", x));
    }
}
