package com.ly.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_366_palindromePairs {


    public static List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        int strLen = words.length;
        for (int i = 0; i < strLen - 1; i++) {
            for (int j = i + 1; j < strLen; j++) {
                if (checkPalindrome(words[i] + words[j])) {
                    resList.add(Arrays.asList(i, j));
                }
                if (checkPalindrome(words[j] + words[i])) {
                    resList.add(Arrays.asList(j, i));
                }
            }
        }
        return resList;
    }


    static boolean checkPalindrome(String str) {
        char[] strArr = str.toCharArray();
        int r = strArr.length - 1;
        int l = 0;
        while (r >= l) {
            if (strArr[l] == strArr[r]) {
                r--;
                l++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testArray = new String[]{"bat","tab","cat"};
        System.err.println(palindromePairs(testArray));

    }
}
