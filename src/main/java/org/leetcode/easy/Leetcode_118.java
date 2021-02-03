package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
    118. Pascal's Triangle
 */
/*
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
*/
public class Leetcode_118 {

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();

        for (int hh = 1; hh <= numRows; hh++) {
            List<Integer> rowList = new ArrayList<>();
            if (hh == 1 || hh == 2) {
                for (int rr = 1; rr <= hh; rr++) {
                    rowList.add(1);
                }
            } else {
                for (int rr = 1; rr <= hh; rr++) {
                    if (rr == 1 || rr == hh) {
                        rowList.add(1);
                    } else {
                        List<Integer> preList = ansList.get(ansList.size() - 1);
                        for (int i = 0; i < preList.size() - 1; i++) {
                            int ss = preList.get(i) + preList.get(i + 1);
                            rowList.add(ss);

                            if (i + 1 == preList.size() - 1) {
                                rr = hh - 1;
                                break;
                            }
                        }
                    }
                }
            }
            ansList.add(hh - 1, rowList);
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        for (List<Integer> iii : list) {
            System.out.println(iii);
        }
    }

}
