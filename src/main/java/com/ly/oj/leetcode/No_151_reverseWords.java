package com.ly.oj.leetcode;

public class No_151_reverseWords {

    public static void main(String args[]) {
        System.out.println(reverseWords("   "));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        while (s.indexOf("  ") > -1) {
            s = s.replace("  ", " ");
        }
        if (s == " ") {
            return "";
        }
        while (s.length() != 0 && s.charAt(0) == ' ') {
            s = s.substring(1, s.length());
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
        String res = sb.toString();
        while (res.length() != 0 && res.charAt(0) == ' ') {
            res = res.substring(1, s.length());
        }
        return res;
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
