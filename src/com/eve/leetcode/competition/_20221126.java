package com.eve.leetcode.competition;

import com.eve.leetcode.medium.list.ListNode;

import java.util.*;

public class _20221126 {

    public int pivotInteger(int n) {
        int sum = (1 + n) * n / 2;
        int i = 1;
        while (i <= n) {
            int pretotal = (1 + i) * i / 2;
            if (sum - pretotal + i == pretotal) return i;
            i++;
        }
        return -1;
    }

    public static int appendCharacters(String s, String t) {
        int sp = 0, tp = 0;
        while (sp < s.length() && tp < t.length()) {
            while (sp < s.length() && s.charAt(sp) != t.charAt(tp)) {
                sp++;
            }
            if (sp < s.length() && s.charAt(sp) == t.charAt(tp)) {
                tp++;
                sp++;
            }
        }
        return t.length() - tp;
    }


    public static ListNode removeNodes(ListNode head) {

        ListNode dummy = new ListNode();
        Deque<ListNode> stack = new ArrayDeque<>();
        stack.offerLast(head);
        head = head.next;
        while (head != null) {
            while (!stack.isEmpty()) {
                ListNode last = stack.pollLast();
                if (last.val >= head.val) {
                    stack.offerLast(last);
                    break;
                }
            }
            stack.offerLast(head);
            head = head.next;
        }
        ListNode res = new ListNode();
        dummy.next = res;
        res.next = stack.pollFirst();
        res = res.next;
        while (!stack.isEmpty()) {
            res.next = stack.pollFirst();
            res = res.next;
        }
        return dummy.next.next;

    }

    public static void main(String[] args) {
        //System.out.println(appendCharacters("coaching","coding"));
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        removeNodes(head);

    }

    public int countSubarrays(int[] nums, int k) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) nums[i] = -1;
            else if (nums[i] > k) nums[i] = 1;
            else {
                nums[i] = 0;
                idx = i;
            }
        }
        int[] dp =  new int[nums.length];
        for(int i = idx-1; i >=0;--i){
            dp[i] = dp[i+1];
        }


        return 0;

    }
}
