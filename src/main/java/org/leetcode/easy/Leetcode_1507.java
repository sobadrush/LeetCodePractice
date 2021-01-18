package org.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Example 1:
    Input: date = "20th Oct 2052"
    Output: "2052-10-20"

    Example 2:
    Input: date = "6th Jun 1933"
    Output: "1933-06-06"

    Example 3:
    Input: date = "26th May 1960"
    Output: "1960-05-26"

    Constraints:
    The given dates are guaranteed to be valid, so no error handling is necessary.
 */
public class Leetcode_1507 {

    private static Map<String, String> MONTH_MAP = new HashMap<String, String>(){
        {
            // "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            super.put("Jan", "01");
            super.put("Feb", "02");
            super.put("Mar", "03");
            super.put("Apr", "04");
            super.put("May", "05");
            super.put("Jun", "06");
            super.put("Jul", "07");
            super.put("Aug", "08");
            super.put("Sep", "09");
            super.put("Oct", "10");
            super.put("Nov", "11");
            super.put("Dec", "12");
        }
    };

    private static String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();

        String[] partStr = date.split(" ");
        for (int i = partStr.length - 1; i >= 0 ; i--) {
            String ss = partStr[i];

            if (i == partStr.length - 1){
                sb.append(ss);
            }
            if (i ==  partStr.length - 1 - 1){
                sb.append(MONTH_MAP.get(ss));
            }
            if (i ==  partStr.length - 1 - 1 - 1){
                sb.append(findDigitStr(ss));
            }
            if (i != 0){
                sb.append("-");
            }
        }

        return sb.toString().trim();
    }

    private static String findDigitStr(String monthStr){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(monthStr);
        if (matcher.find()){
            // System.out.println(matcher.group(0));
            return String.format("%02d", Integer.parseInt( matcher.group(0) ));
        }
        return "";
    }

    public static void main(String[] args) {
        // String date = "20th Oct 2052";
        String date = "6th Jun 1933";
        System.out.println("ans = " + reformatDate(date));


    }

}
