package com.eve.leetcode.easy;

import com.eve.leetcode.medium.list.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Eve on 2022/8/31.
 */


public class _234_isParlindrome {

        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stack =  new Stack<>();
            Queue<Integer> queue =  new ArrayDeque<>();
            int len=0;
            while(head.next != null){
                len++;
                stack.push(head.val);
                queue.offer(head.val);
                head = head.next;
            }
            while(!stack.isEmpty() && stack.pop()==queue.poll()  ){
            }
            return stack.isEmpty()?true:false;
        }
}
