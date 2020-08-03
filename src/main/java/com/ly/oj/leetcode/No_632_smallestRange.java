package com.ly.oj.leetcode;


import java.util.*;

public class No_632_smallestRange {


    public static int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0)
            return null;
        int len = nums.size();
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.value));
        int[] res = new int[]{-100000, 100000};
        //maxNum 记录每一次遍历中k个数组的最大值
        int maxNum = Integer.MIN_VALUE;
        //初始化优先队列，将k个数组的第一个数字入队
        for (int i = 0; i < len; i++) {
            int num = nums.get(i).get(0);
            maxNum = Math.max(maxNum, num);
            queue.add(new Pair(i, 0, num));
        }
        //这里的循环退出条件是队列为空，也可以写成双层循环遍历数组
        while (!queue.isEmpty()) {
            //每次遍历，先从队列中取出当前最小值
            Pair pair = queue.poll();
            int num = pair.value;
            //如果（当前最小值，当前最大值）的区间范围更小，则修改res数组
            if (res[1] - res[0] > maxNum - num) {
                res[0] = num;
                res[1] = maxNum;
            }
            int row = pair.row;
            int col = pair.col + 1; //右移
//            queue.forEach(a -> System.err.print(a + ", "));
//            System.err.print("maxNum: " + maxNum + ", ");
//            System.err.println("res is:" + Arrays.toString(res));

            //如果右移后超出数组长度，此时退出循环，即已经找到最小的区间了
            if (nums.get(row).size() == col) {
                break;
            }
            //下一个数，是当前数右边的数
            int nextNum = nums.get(row).get(col);
            //下一个数继续入队列
            queue.add(new Pair(row, col, nextNum));
            //更新当前最大值
            maxNum = Math.max(maxNum, nextNum);

        }
        return res;
    }

    //定义一个类，用来记录遍历过程中，每个数字所在的行、列和数字对应的值
    static class Pair {
        public Integer row;
        public Integer col;
        public Integer value;

        public Pair(Integer row, Integer col, Integer value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "row=" + row +
                    ", col=" + col +
                    ", num=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.err.println(Arrays.toString(smallestRange(nums)));
    }
}
