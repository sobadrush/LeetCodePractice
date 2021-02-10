package org.leetcode.easy;

/*
    121. Best Time to Buy and Sell Stock
*/
/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/
/*
    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

    Constraints:
    1 <= prices.length <= 105
    0 <= prices[i] <= 104
 */
public class Leetcode_121 {

    /**
     * Kadane’s Algorithm (卡登算法)
     * ref. https://zhuanlan.zhihu.com/p/96014673
     */
    private static int maxProfit(int[] prices) {
        int localProfit = 0;
        int absProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            localProfit = localProfit + (prices[i + 1] - prices[i]); // 累計的價差
            localProfit = Math.max(0, localProfit); // 累計價差 < 0 → 賠錢 → 把localProfile設成0 → 不賣
            // System.out.println(localProfit);
            absProfit = Math.max(absProfit, localProfit); // 絕對最大價差
        }
        return absProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 7,1,5,3,6,4 };
        System.out.println("ans = " + maxProfit(arr));
    }
}
