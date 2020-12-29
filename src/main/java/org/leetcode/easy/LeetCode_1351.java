package org.leetcode.easy;

/*
    Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
    Return the number of negative numbers in grid.

    Example 1:

    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    Output: 8
    Explanation: There are 8 negatives number in the matrix.
    Example 2:

    Input: grid = [[3,2],[1,0]]
    Output: 0
    Example 3:

    Input: grid = [[1,-1],[-1,-1]]
    Output: 3
    Example 4:

    Input: grid = [[-1]]
    Output: 1
 */
/*
    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100
 */
public class LeetCode_1351 {

    public static int countNegatives(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        int total = 0;
        for (int rr = 0; rr < rowLen; rr++) {
            int postiveNum = 0;
            for (int cc = 0; cc < colLen; cc++) {
                int elem = grid[rr][cc];
                if(elem >= 0) {
                    postiveNum++;
                    continue;
                }
                break;
            }
            total += (colLen - postiveNum);
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println("ans1 = " + countNegatives(grid));
    }
}
