package com.eve.leetcode.medium.list;

/**
 * Created by Eve on 2022/9/7.
 */
public class _142_detectCycle {


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) break;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
