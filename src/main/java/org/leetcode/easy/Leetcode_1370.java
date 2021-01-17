package org.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 1370. Increasing Decreasing String
 */
/*
    Given a string s. You should re-order the string using the following algorithm:

    Pick the smallest character from s and append it to the result.
    Pick the smallest character from s which is greater than the last appended character to the result and append it.
    Repeat step 2 until you cannot pick more characters.
    Pick the largest character from s and append it to the result.
    Pick the largest character from s which is smaller than the last appended character to the result and append it.
    Repeat step 5 until you cannot pick more characters.
    Repeat the steps from 1 to 6 until you pick all characters from s.
    In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

    Return the result string after sorting s with this algorithm.
 */
/*
    Example 1:
    Input: s = "aaaabbbbcccc"
    Output: "abccbaabccba"

    Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
    After steps 4, 5 and 6 of the first iteration, result = "abccba"
    First iteration is done. Now s = "aabbcc" and we go back to step 1
    After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
    After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 */
public class Leetcode_1370 {

    public static String sortString(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        char[] chArr = s.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            char tmpCh = chArr[i];
            hmap.put(tmpCh, hmap.getOrDefault(tmpCh, 0) + 1);
        }
        System.out.println(hmap);
        if (hmap.keySet().size() == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sbForReverse = new StringBuilder();
        Set<Character> kSet = hmap.keySet();

        if (kSet.size() > 0){
            Iterator<Character> itor = kSet.iterator();
            while (itor.hasNext()){
                Character kk = itor.next();
                Integer vv = hmap.get(kk);
                if (vv > 0){
                    sb.append(kk);
                    hmap.put( kk, vv - 1 );
                }
            }
            System.out.println(hmap);



            itor = kSet.iterator();
            while (itor.hasNext()){
                Character kk = itor.next();
                Integer vv = hmap.get(kk);
                if (vv > 0){
                    sbForReverse.append(kk);
                    hmap.put( kk, vv - 1 );
                }
            }

            String rvsString = sbForReverse.reverse().toString();
            System.out.println("rvsString " + rvsString);
            sb.append(rvsString);

            System.out.println(sb.toString());
        }

        return "";
    }

    public static void main(String[] args) {
        // String input = "ggggggg";
        String input = "aaaabbbbcccc";
        String ans = sortString(input);
        System.out.println("ans = " + ans);
    }
}
