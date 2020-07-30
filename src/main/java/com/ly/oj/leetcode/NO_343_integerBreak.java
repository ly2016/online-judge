package com.ly.oj.leetcode;

public class NO_343_integerBreak {


    /**
     * dp(n) = dp(n-m) * m
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.err.println(integerBreak(10));
    }
}
