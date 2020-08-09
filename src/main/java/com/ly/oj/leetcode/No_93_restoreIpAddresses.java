package com.ly.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No_93_restoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return null;
        }
        List<String> ips = new ArrayList<>();
        String str1, str2, str3, str4;
        for (int i = 1; i < 4; i++) {
            str1 = s.substring(0, i);
            if (!checkIfIpNumber(str1)) {
                continue;
            }
            for (int j = i + 1; j < i + 4 && j < s.length(); j++) {
                str2 = s.substring(i, j);
                if (!checkIfIpNumber(str2)) {
                    continue;
                }
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {
                    str3 = s.substring(j, k);
                    str4 = s.substring(k, s.length());
                    if (!checkIfIpNumber(str3) || !checkIfIpNumber(str4)) {
                        continue;
                    }
                    String ip = str1 + "." + str2 + "." + str3 + "." + str4;
                    ips.add(ip);
                }
            }
        }
        return ips;
    }


    static boolean checkIfIpNumber(String iPStr) {
        if (iPStr == null || iPStr.length() <= 0 || iPStr.length() > 3 || (iPStr.length() > 1 && iPStr.charAt(0) == '0')) {
            return false;
        }
        int numIp = Integer.parseInt(iPStr);
        return numIp >= 0 && numIp <= 255;
    }

    public static void main(String[] args) {
        System.err.println(restoreIpAddresses("101023"));
        //System.err.println(checkIfIpNumber("01"));
    }

}
