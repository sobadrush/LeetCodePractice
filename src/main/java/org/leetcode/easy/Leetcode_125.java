package org.leetcode.easy;

/*
    125. Valid Palindrome
 */
/*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
/*
    Example 1:
        Input: "A man, a plan, a canal: Panama"
        Output: true
        explain: 它扣掉空白、逗號、分號，全轉成小寫的話，會是"amanaplanacanalpanama"，會是左右對稱的回文 (僅英文&數字)

    Example 2:
        Input: "race a car"
        Output: false

    Constraints:
        s consists only of printable ASCII characters.
 */
public class Leetcode_125 {

    private static boolean isPalindrome(String s) {

        if (s.length() == 1 || s.length() == 0) return true;

        s = s.replaceAll("[^a-zA-Z0-9]|\\s", "").toLowerCase();

        // System.out.println(s);

        if (s.equals("")) return true;

        int leftIndex = 0;
        int rigthIndex = s.length() - 1;

        for (leftIndex = 0; leftIndex < s.length(); leftIndex++) {
            if (leftIndex == rigthIndex) break;
            if (s.charAt(leftIndex) != s.charAt(rigthIndex)){
                return false;
            }
            rigthIndex--;
        }
        return true;
    }

    // private static boolean isPalindrome(String s) {
    //     int start = 0;
    //     s = s.replaceAll("[^a-zA-Z0-9]", "");
    //     System.out.println("s = " + s);
    //     int end = s.length() - 1;
    //
    //     while(start < end){
    //         char ci = Character.toLowerCase(s.charAt(start));
    //         char cj = Character.toLowerCase(s.charAt(end));
    //
    //         if(!s.valueOf(ci).equals(s.valueOf(cj))){
    //             return false;
    //         }
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        // String str = "A man, a plan, a canal: Panama";
        // String str = "race a car";
        // String str = "a."; // T OK
        // String str = "a"; // T OK
        // String str = " "; // T OK
        // String str = ""; // T OK
        String str = ".,"; // T OK
        // String str = "0P"; // F OK
        System.out.println("ans = " + isPalindrome(str));
    }

}
