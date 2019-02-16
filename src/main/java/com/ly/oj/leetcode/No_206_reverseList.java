package com.ly.oj.leetcode;

import com.ly.oj.leetcode.structure.ListNode;
import com.ly.oj.leetcode.utils.OperateList;

public class No_206_reverseList {

    public static void main(String[] args) {
        OperateList.printListNode(reverseList(OperateList.createListWithHeadPoint(new int[]{1, 2, 4, 5})));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode resHead = new ListNode(-1);
        resHead.next = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = resHead.next;
            resHead.next = tmp;
            head = head.next;
        }
        return resHead.next;
    }
}
