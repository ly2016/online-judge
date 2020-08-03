package com.ly.oj.leetcode;

public class No_415_addStrings {


    public static String addStrings(String num1, String num2) {
        if (num1.equals("") || num2.equals("")) {
            return num1.equals("") ? num2 : num1;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int i = 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 - i >= 0 || len2 - i >= 0 || carry != 0) {
            int c1 = 0, c2 = 0;
            if (len1 - i >= 0) {
                c1 = num1.charAt(len1 - i) - '0';
            }
            if (len2 - i >= 0) {
                c2 = num2.charAt(len2 - i) - '0';
            }
            int sum = c1 + c2 + carry;
            int value = sum % 10;
            carry = sum / 10;
            i++;
            sb.append(value);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.err.println(addStrings("11", "231"));
    }
}
