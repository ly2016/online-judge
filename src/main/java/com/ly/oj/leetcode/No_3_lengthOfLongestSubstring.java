package com.ly.oj.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class No_3_lengthOfLongestSubstring {

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] arr1 = s.toCharArray();
        Set<Character> child = new LinkedHashSet<>();
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i; j < arr1.length; j++) {
                int size = child.size();
                child.add(arr1[j]);
                if (child.size() == size) {
                    break;
                }
            }
            max = max > child.size() ? max : child.size();
            child.clear();
        }
        return max;
    }
}

