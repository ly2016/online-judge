package com.ly.oj.leetcode;

public class NO_567_checkInclusion {

    /**
     * 未通过样例
     *  输入 "abc" "bbbca" 输出 false 预期结果 true
     */
    public static void main(String[] args) {
        System.out.println(checkInclusion("abc"
                ,"bbbca"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length() || s2 == null) {
            return false;
        }
        int upright, reverse;
        upright = reverse = 0;
        String tmp2;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (i + j > s2.length() - 1) {
                    upright = 0;
                    break;
                } else if (s2.charAt(i + j) == s1.charAt(j)) {
                    upright = 1;
                    tmp2 = s1.substring(0,j);
                } else {
                    upright = 0;
                    break;
                }
            }
            if (upright == 1) {
                break;
            }
        }

        char[] str = s1.toCharArray();
        int l = 0;
        int r = str.length - 1;
        while (l <= r) {
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
        String s3 = new String(str);


        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s3.length(); j++) {
                if (i + j > s2.length() - 1) {
                    reverse = 0;
                    break;
                } else if (s2.charAt(i + j) == s3.charAt(j)) {
                    reverse = 1;
                    tmp2 = s3.substring(0,j);
                } else {
                    reverse = 0;
                    break;
                }
            }
            if (reverse == 1) {
                break;
            }
        }
        return upright == 1 || reverse == 1;
    }

}


