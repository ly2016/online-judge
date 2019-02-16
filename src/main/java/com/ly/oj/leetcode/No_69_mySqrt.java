package com.ly.oj.leetcode;

public class No_69_mySqrt {

    /**
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int middle = 0;
        while (left <= right) {
            middle = right - (right - left) / 2;
            long multiply = (long) middle * middle; /*尽管已经提前设置了multiply为long，但是结果是在int相乘溢出后才转long*/
            if (multiply > x) {
                right = middle - 1;
            } else if (multiply < x) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right; /*这里返回middle（可能偏大） 和 left（一定偏大）都会错误*/
    }
}
