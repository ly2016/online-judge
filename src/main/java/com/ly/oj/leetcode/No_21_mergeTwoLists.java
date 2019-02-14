package com.ly.oj.leetcode;

import com.ly.oj.leetcode.structure.ListNode;
import com.ly.oj.leetcode.utils.OperateList;

public class No_21_mergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = OperateList.createListWithHeadPoint(new int[]{0, 1, 2, 6, 7});
        ListNode l2 = OperateList.createListWithHeadPoint(new int[]{1, 2, 3, 9});
        ListNode l3 = mergeTwoLists(l1.next, l2.next);
        OperateList.printListNode(l3);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
            if (l1 == null) {
                prev.next = l2;
            } else if (l2 == null) {
                prev.next = l1;
            }
        }
        return result.next;
    }

}
