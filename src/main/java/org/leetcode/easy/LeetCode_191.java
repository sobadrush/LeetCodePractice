package org.leetcode.easy;

public class LeetCode_191 {

    public static int hammingWeight(int n) {
        String binaryN = Integer.toBinaryString(n);
        int cc = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1'){
                cc++;
            }
        }
        return cc;
    }

    public static void main(String[] args) {
        System.out.println("ans1 = " + hammingWeight(-3));
    }
}
