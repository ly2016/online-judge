package com.ly.oj.leetcode.utils;

import com.ly.oj.leetcode.structure.ListNode;

public class OperateList {

    public static void main(String[] args) {
        ListNode link = createListWithHeadPoint(new int[]{1, 2, 3, 7, 8});
        printListNode(link);
        printListNode(link);
    }

    /**
     * 尾插法生成单链表
     *
     * @param arr
     * @return
     */
    public static ListNode createListWithHeadPoint(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode rear = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            tmp.next = null;
            rear.next = tmp;
            rear = tmp;
        }
        rear.next = null;
        return head;
    }

    /**
     * 打印单链表
     *
     * @param head
     */
    public static void printListNode(ListNode head) {
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            System.err.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.err.println(tmp.val);
    }
}
