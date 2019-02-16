package com.ly.oj.leetcode;

import com.ly.oj.leetcode.utils.OperateString;

import static com.ly.oj.leetcode.utils.OperateString.reversalStr;

public class No_151_reverseWords {

    public static void main(String args[]) {
        System.out.println(reverseWords(" 1"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        if (s.equals("")) {
            return "";
        }
        while (s.contains("  ")) {
            s = s.replace("  ", " ");
        }
        String rev1 = reversalStr(s);
        String[] rev2 = rev1.split(" ");
        if (rev2.length == 0) {
            return "";
        }
        for (int i = 0; i < rev2.length; i++) {
            rev2[i] = OperateString.reversalStr(rev2[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(rev2[0]);
        for (int i = 1; i < rev2.length; i++) {
            sb.append(" ").append(rev2[i]);
        }
        return sb.toString();
    }


}
