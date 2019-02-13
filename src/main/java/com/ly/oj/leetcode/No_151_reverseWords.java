package com.ly.oj.leetcode;

public class No_151_reverseWords {

    public static void main(String args[]) {
        System.out.println(reverseWords(" 1"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        if (s == "") {
            return "";
        }
        while (s.indexOf("  ") > -1) {
            s = s.replace("  ", " ");
        }
        String rev1 = reversal(s);
        String[] rev2 = rev1.split(" ");
        if (rev2.length == 0) {
            return "";
        }
        for (int i = 0; i < rev2.length; i++) {
            rev2[i] = reversal(rev2[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(rev2[0]);
        for (int i = 1; i < rev2.length; i++) {
            sb.append(" " + rev2[i]);
        }
        return sb.toString();
    }


    static String reversal(String str) {
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
