package com.ly.oj.leetcode;

public class No_393_validUtf8 {

    public static void main(String args[]) {
        System.err.println(validUtf8(new int[]{197, 130, 1}));
    }

    public static boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            if (cnt == 0) {
                if (data[i] >> 5 == 0b110) {
                    cnt = 1;
                } else if (data[i] >> 4 == 0b1110) {
                    cnt = 2;
                } else if (data[i] >> 3 == 0b11110) {
                    cnt = 3;
                } else if (data[i] >> 7 == 1) { /*首字符为1XXX XXXX 是错误值，但0XXX XXXX可表示单个字符*/
                    return false;
                }
            } else {
                if (data[i] >> 6 != 0b10) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }

    /**
     * 下面的方法也可用于确认最高位
     *
     * @param num
     * @return
     */
    public int getHeadType(int num) {
        if ((num & 0b11111000) == 0b11110000) return 3;
        if ((num & 0b11110000) == 0b11100000) return 2;
        if ((num & 0b11100000) == 0b11000000) return 1;
        if ((num & 0b10000000) == 0b10000000) return -1; //error
        return 0;
    }
}
