package com.ly.oj.leetcode;

public class No_696_countBinarySubstrings {

    public static int countBinarySubstrings(String s) {
        int res = 0;
        if (s == null || s.length() < 2) {
            return res;
        }
        char[] strArr = s.toCharArray();
        int len = strArr.length;
        for (int i = 0; i < len; i++) {
            int index = 0;
            while ((i + index) < len && strArr[i] == strArr[i + index]) {
                index++;
            }
            for (int j = i + index; j < i + 2 * index && j < len; j++) {
                if (strArr[i] == strArr[j]) {
                    break;
                }
                if (j == i + 2 * index - 1) {
                    res++;
                }
            }

        }
        return res;
    }

    public static int countBinarySubstrings2(String s) {
        int res = 0;
        if (s == null || s.length() < 2) {
            return res;
        }
        int len = s.length();
        char[] strArr = s.toCharArray();
        for (int mirrorIndex = 1; mirrorIndex < len; mirrorIndex++) {
            for (int i = 1; i + mirrorIndex <= len && mirrorIndex - i >= 0; i++) {
                if (strArr[mirrorIndex - i] != strArr[mirrorIndex + i - 1] && strArr[mirrorIndex] == strArr[mirrorIndex + i - 1]) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.err.println(countBinarySubstrings2("00110"));

    }


}
