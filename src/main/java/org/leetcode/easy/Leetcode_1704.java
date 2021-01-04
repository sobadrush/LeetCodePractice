package org.leetcode.easy;


import java.util.*;

/*
    You are given a string s of even length. Split this string into two halves of equal lengths,
    and let a be the first half and b be the second half.
    Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
    Return true if a and b are alike. Otherwise, return false.
 */
/*
    Example 1:

    Input: s = "book"
    Output: true
    Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
    Example 2:

    Input: s = "textbook"
    Output: false
    Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
    Notice that the vowel o is counted twice.
    Example 3:

    Input: s = "MerryChristmas"
    Output: false
    Example 4:

    Input: s = "AbCdEfGh"
    Output: true
 */
public class Leetcode_1704 {

    private static boolean halvesAreAlike(String s) {

        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> vowelsList = new ArrayList<>();
        for (int i = 0; i < vowels.length; i++) {
            char ch = vowels[i];
            vowelsList.add(ch);
        }
        
        char[] inputChArr = s.toCharArray();
        int halfA = 0;
        int halfB = 0;
        for (int i = 0; i < inputChArr.length; i++) {
            char ch = inputChArr[i];
            if (i < (inputChArr.length / 2)){
                if (vowelsList.contains(ch)){
                    halfA++;
                }
            } else{
                if (vowelsList.contains(ch)){
                    halfB++;
                }
            }
        }
        return halfB == halfA;
    }

    public static void main(String[] args) {
        String input = "AbCdEfGh";
        System.out.println(halvesAreAlike(input));
    }

}
