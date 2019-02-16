package com.ly.oj.leetcode.utils;

public class OperateString {

    public static void main(String[] args) {

    }

    public static String reversalStr(String str) {
        char reversal[] = str.toCharArray();
        int l, r;
        l = 0;
        r = str.length() - 1;
        while (l <= r) {
            char tmp = reversal[l];
            reversal[l] = reversal[r];
            reversal[r] = tmp;
            l++;
            r--;
        }
        return new String(reversal);
    }
}
