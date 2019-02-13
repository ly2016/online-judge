package com.ly.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_15_threeSum {

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break; /* nums是递增排列的，nums[i]是第一个数，如果大于0,后面两数不小于nums[i],和不可能为0 */
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; /* 去重处理，nums[i-1]遍历过一次的情况下,如果nums[i]相等,找到的结果一定重复。
                 i > 0 为了避免 i = 0时 i - 1导致数组越界。*/
            }
            int twoSum = -nums[i];
            int left = i + 1; /* 去重处理，如果left从0开始，找到答案的在数组中的排列是
             left,nums[i],right，
             那么在这之前一定有相同答案排列为nums[i],left,right。*/
            int right = len - 1;
            while (left < right) {
                if (twoSum == nums[left] + nums[right]) {
                    List<Integer> member = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(member);
                    while (left < right && nums[left++] == nums[left]) {
                    }
                    while (left < right && nums[right--] == nums[right]) {
                    } // 去重处理，更新left和right的值后继续寻找答案
                } else if (nums[left] + nums[right] > twoSum) {
                    while (left < right && nums[right--] == nums[right]) {
                    }
                } else {
                    while (left < right && nums[left++] == nums[left]) {
                    }
                }
            }
        }
        return result;
    }
}
