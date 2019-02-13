package com.ly.oj.leetcode;

public class No_53_maxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = sum > max ? sum : max;
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    }
}

