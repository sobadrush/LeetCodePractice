package org.leetcode.easy;

import java.util.*;

/*
    Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

    A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

    Example 1:

    Input: matrix = [
        [3,7,8],
        [9,11,13],
        [15,16,17]
    ]
    Output: [15]
    Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
    Example 2:

    Input: matrix = [
        [1,10,4,2],
        [9,3,8,7],
        [15,16,17,12]
    ]
    Output: [12]
    Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
    Example 3:

    Input: matrix = [
        [7,8],
        [1,2]
    ]
    Output: [7]
 */
public class Leetcode_1380 {

    private static void findMinInArr(int[] mat, int numOfRow, Map<Integer, int[]> hmap) {
        int minIdx = 0;
        int minInRow = mat[minIdx];
        for (int j = 1; j < mat.length; j++) {
            if (minInRow > mat[j]) {
                minIdx = j;
                minInRow = mat[j];
            }
        }
        hmap.put(numOfRow, new int[]{minInRow, minIdx});
    }

    private static List<Integer> luckyNumbers(int[][] matrix) {

        Map<Integer, int[]> hmap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            findMinInArr(row, i, hmap);
        }

        List<Integer> ansList = new ArrayList<>();

        Set<Map.Entry<Integer, int[]>> eSet = hmap.entrySet();
        for (Map.Entry<Integer, int[]> entry : eSet) {
            int rowNum = entry.getKey();
            int rowMin = entry.getValue()[0];
            int minColIdx = entry.getValue()[1];

            int colMax = matrix[0][minColIdx];
            for (int rr = 1; rr < matrix.length; rr++) {
                if (matrix[rr][minColIdx] > colMax){
                    colMax = matrix[rr][minColIdx];
                }
            }

            if (colMax == rowMin){
                ansList.add(colMax); // colMax == rowMin == luckynumber
            }
        }


        // hmap.entrySet().stream().forEach((entry) -> {
        //     int[] myMap = entry.getValue();
        //     System.out.println(entry.getKey() + " - " + myMap);
        //     for (int aa : myMap) {
        //         System.out.println(aa);
        //     }
        // });

        return ansList;
    }

    public static void main(String[] args) {
        // Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
        // int[][] input = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        // Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        // int[][] input = new int[][]{{1,10,4,2}, {9,3,8,7}, {15,16,17,12}};
        // Input: matrix = [[7,8],[1,2]]
        int[][] input = new int[][]{{7,8}, {1,2}};
        luckyNumbers(input).forEach(System.out::println);
    }

}
