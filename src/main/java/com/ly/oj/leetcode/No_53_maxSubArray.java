package com.ly.oj.leetcode;

public class No_53_maxSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, -1, 5};
        System.err.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
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

