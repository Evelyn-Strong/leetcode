package com.eve.leetcode.easy;

import com.eve.leetcode.medium.list.ListNode;

/**
 * Created by Eve on 2022/9/5.
 */
public class _141_hasCycle {


    //快慢指针
    public boolean hasCycle(ListNode head) {

        ListNode slow = new ListNode();
        slow.next = head;
        ListNode fast = new ListNode();
        fast.next = head;
        while(slow != fast){

            if(slow.next == null) return false;
            else{
                slow =  slow.next;
                if(fast.next != null && fast.next.next != null){
                    fast= fast.next.next;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
