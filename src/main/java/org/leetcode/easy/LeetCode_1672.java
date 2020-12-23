package org.leetcode.easy;

public class LeetCode_1672 {

    private static int sumOfArray(int[] arr){
        int i = 0;
        int sum = 0;
        while (i < arr.length){
            sum += arr[i++];
        }
        return sum;
    }

    private static int maximumWealth(int[][] accounts) {
        int max = sumOfArray(accounts[0]);
        for (int i = 0; i < accounts.length; i++) {
            for (int j = i + 1; j < accounts.length; j++) {
                if (sumOfArray(accounts[j]) > max) {
                    max = sumOfArray(accounts[j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {3, 2, 1}};
        System.out.println("ans1 = " + maximumWealth(input));
    }
}
