package com.ly.oj.leetcode;

public class No_121_maxProfit {

    /**
     * O（n*n）
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int s = 0; s < prices.length; s++) {
            for (int i = 1 + s; i < prices.length; i++) {
                int tmp = prices[i] - prices[s];
                maxProfit = tmp > maxProfit ? tmp : maxProfit;
            }
        }
        return maxProfit > 0 ? maxProfit : 0;
    }
}
