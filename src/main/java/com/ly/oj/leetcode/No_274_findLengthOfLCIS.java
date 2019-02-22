package com.ly.oj.leetcode;

public class No_274_findLengthOfLCIS {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }


    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxLength++;
            } else {
                res = res > maxLength ? res : maxLength;
                maxLength = 1;
                continue;
            }
        }
        return res > maxLength ? res : maxLength;
    }
}
