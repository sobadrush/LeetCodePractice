package org.leetcode.easy;

/*
    122. Best Time to Buy and Sell Stock II
 */
/*
    Say you have an array prices for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete as many transactions as you
    like (i.e., buy one and sell one share of the stock multiple times).
    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
/*
    Example 1:
        Input: [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                     Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    Example 2:
        Input: [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                     Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
                     engaging multiple transactions at the same time. You must sell before buying again.

    Example 3:
        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.

    Constraints:
    1 <= prices.length <= 3 * 10 ^ 4
    0 <= prices[i] <= 10 ^ 4
 */
public class Leetcode_122 {

    /*
        卡登演算法( karden alogthrim )
     */
    private static int maxProfit(int[] prices) {
        int absProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int localProfit = prices[i+1] - prices[i]; // 計算局部的獲利
            localProfit = Math.max(localProfit, 0); // 若獲利 < 0 → 不賣 → 把局部獲利設成 0
            // System.out.println("localprofit = " + localProfit);
            absProfit += localProfit; // 累計局部獲利成為絕對獲利
        }
        return absProfit;
    }

    public static void main(String[] args) {
        // int[] prices = new int[]{ 7,1,5,3,6,4 };
        // System.out.println("MaxProfit = " + maxProfit(prices)); // ans should be 7

        // int[] prices = new int[]{ 1,2,3,4,5 };
        // System.out.println("MaxProfit = " + maxProfit(prices)); // ans should be 7

        int[] prices = new int[]{ 7,6,4,3,1 };
        System.out.println("MaxProfit = " + maxProfit(prices)); // ans should be 7
    }
}
