package org.leetcode.easy;

/*
    121. Best Time to Buy and Sell Stock
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

    1 <= prices.length <= 10^5
    0 <= prices[i] <= 10^4
 */
public class Leetcode_121v2 {

    private static int maxProfit(int[] prices) {
        int localProfit = 0;
        int absProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            localProfit += prices[i + 1] - prices[i];
            localProfit = Math.max(0, localProfit);
            absProfit = Math.max(absProfit, localProfit);
        }
        return absProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 7,1,5,3,6,4 };
        System.out.println("ans = " + maxProfit(prices));
    }

}

