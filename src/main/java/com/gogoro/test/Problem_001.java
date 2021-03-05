package com.gogoro.test;

/*
    What is the print result for followeing codes?
 */

public class Problem_001 {
    public static void main(String[] args) {
        String s1 = "goshare";
        String s2 = "goshare";
        String s3 = new String("goshare");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }
}
