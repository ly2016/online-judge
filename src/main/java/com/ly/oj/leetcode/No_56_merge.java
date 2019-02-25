package com.ly.oj.leetcode;

import com.ly.oj.leetcode.structure.Interval;

import java.util.ArrayList;
import java.util.List;

public class No_56_merge {

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();

        Interval l1 = new Interval(1, 4);
        Interval l2 = new Interval(0, 4);
        Interval l3 = new Interval(4, 6);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        System.err.println(merge(list).toString());
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Interval first;
        Interval second;
        List<Interval> intervalsReturn = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            first = intervals.get(i);
            int j = i + 1;
            for (; j < intervals.size(); j++) {
                second = intervals.get(j);
                if (!(first.end < second.start || first.start > second.end)) {
                    second.end = Math.max(first.end, second.end);
                    second.start = Math.min(first.start, second.start);
                    break;
                }
            }
            if (j == intervals.size()) {
                intervalsReturn.add(intervals.get(i));
            }
        }
        return intervalsReturn;
    }

    public static List<Interval> merge2(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        Interval L = new Interval();//一层循环保存对象
        Interval R = new Interval();//二层循环保存对象
        for (int i = 0; i < intervals.size(); i++) {
            L = intervals.get(i);
            int j = i + 1;
            for (; j < intervals.size(); j++) {
                R = intervals.get(j);
                if (R.start == L.start) {
                    intervals.set(j, new Interval(L.start, Math.max(L.end, R.end)));
                    break;
                } else if (L.start < R.start) {
                    if (L.end >= R.start) {
                        Interval inter = new Interval(L.start, Math.max(L.end, R.end));
                        intervals.set(j, inter);
                        break;
                    }
                } else {
                    if (R.end >= L.start) {
                        Interval inter = new Interval(R.start, Math.max(L.end, R.end));
                        intervals.set(j, inter);
                        break;
                    }
                }
            }
            if (j == intervals.size()) {
                list.add(intervals.get(i));
            }
        }
        return list;
    }

}
