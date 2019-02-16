package com.ly.oj.leetcode;

import com.ly.oj.leetcode.structure.ListNode;
import com.ly.oj.leetcode.utils.OperateList;

import java.util.HashMap;

public class No_142_detectCycle {

    public static void main(String[] args) {
        ListNode l1 = OperateList.createListWithHeadPoint(new int[]{1, 2, 3, 4, 5, 6, 7, 5}).next;
        ListNode tail = l1;
        while (tail.next != null) {
            tail = tail.next;
        }
        int indexCycle = 5; /*入环口*/
        ListNode curr = l1;
        while (indexCycle > 0) {
            curr = curr.next;
            indexCycle--;
        }
        tail.next = curr;
        System.err.println(detectCycle(l1).val);
        System.err.println(detectCycle2(l1).val);
    }

    /**
     * 如果有环，快慢指针必然相遇，相遇时快指针多走的距离就是环的大小。
     * <p>
     * 如图，这是一个环形链表，我们假设链表的起始点到环的入口点的距离为L，环的周长为R，
     * 环的入口点到快慢指针的相遇位置的距离为X（图中红色箭头标注的就是快慢指针的相遇点）。
     * <p>
     * 快指针走的距离：F = L+X+n*R
     * 慢指针走的距离：S = L+X
     * <p>
     * 注意：慢指针一定是走不到一圈就相遇了，因为如果在环的入口点没有相遇的话，快指针的速度是慢指针的两倍，慢指针在入口点时快指针已经进入环内，
     * 在慢指针走完一圈之前，快指针一定会追上它。最差的情况就是在入口点相遇，这是快指针走了两圈，慢指针刚好走了一圈，这个情况后面再讨论。
     * <p>
     * 因为快指针走的距离是慢指针的两倍，所以F = 2*S。
     * 这时：L+X+n*R = 2 * (L + X)
     *            L = n*R - X
     * 当n = 1时，也就是快指针走了一圈之后，在第二圈的时候遇见了慢指针，L = R - X
     * <p>
     * 我们可以发现，L是链表的表头到环的入口点的位置，(R - X)是相遇点到环入口点的位置, 因此设置临时指针从head出发，当tmp走完L时，fast指针刚好走完
     * (R - X)，于是他们在入口处相遇。
     * ---------------------
     * 作者：menqiqi_
     * 来源：CSDN
     * 原文：https://blog.csdn.net/baidu_40931662/article/details/84306202
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 使用额外的空间---HashMap
     */
    public static ListNode detectCycle2(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        if (head == null || head.next == null)
            return null;
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, -1);
                head = head.next;
            } else
                return head;
        }
        return null;
    }

}
