package com.eve.leetcode.medium.list;

import java.util.Stack;

/**
 * Created by Eve on 2022/8/27.
 */
public class _206_reverseList {

    public ListNode reverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = new ListNode();
        ListNode ans = tmp;

        while(head.next != null){
            stack.push(head);
            head =  head.next;
        }

        while(stack.isEmpty()){
            tmp.next = stack.pop();
            tmp = tmp.next;
        }

        return ans.next;
    }
}
