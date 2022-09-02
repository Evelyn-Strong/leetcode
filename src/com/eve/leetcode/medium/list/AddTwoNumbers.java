package com.eve.leetcode.medium.list;

/**
 * Created by Eve on 2022/8/2.
 *
 *
 * Definition for singly-linked list.
 **/

  //位相加=每一个node对应相加，并且计算进位符

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int idx=1;
        boolean flag= false;
        ListNode result = new ListNode();
        ListNode resultFinal = result;

        while(l1!= null || l2!= null) {

            if (l1 != null && l2 != null) {
                int value = (l1.val + l2.val + (flag ? 1 : 0));
                if (value >= 10) {
                    if (idx == 1) {
                        result = new ListNode(value - 10);
                    } else {
                        ListNode next = new ListNode(value - 10);
                        result.next = next;
                        result=result.next;
                    }
                    flag = true;
                } else {
                    if (idx == 1) {
                        result = new ListNode(value);
                    } else {
                        ListNode next = new ListNode(value);
                        result.next = next;
                        result=result.next;
                    }
                    flag = false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 == null) {
                int value = (l2.val + (flag ? 1 : 0));
                if (value >= 10) {
                    if (idx == 1) {
                        result = new ListNode(value - 10);
                    } else {
                        ListNode next = new ListNode(value - 10);
                        result.next = next;
                        result=result.next;
                    }
                    flag = true;
                } else {
                    if (idx == 1) {
                        result = new ListNode(value);
                    } else {
                        ListNode next = new ListNode(value);
                        result.next = next;
                        result=result.next;
                    }
                    flag = false;
                }
                l2 = l2.next;
            }else if (l2 == null) {
                int value = (l1.val + (flag ? 1 : 0));
                if (value >= 10) {
                    if (idx == 1) {
                        result = new ListNode(value - 10);
                    } else {
                        ListNode next = new ListNode(value - 10);
                        result.next = next;
                        result=result.next;
                    }
                    flag = true;
                } else {
                    if (idx == 1) {
                        result = new ListNode(value);
                    } else {
                        ListNode next = new ListNode(value);
                        result.next = next;
                        result=result.next;
                    }
                    flag = false;
                }
                l1 = l1.next;

            }
            if(idx==1) resultFinal = result;
            idx++;
        }
        if(l1 == null && l2==null && flag){
            ListNode next = new ListNode(1);
            result.next = next;
            result=result.next;
        }
        return resultFinal;
    }

    public static void main(String[] args) {
        ListNode  l1 =  new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode  l2 =  new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1,l2));



    }
}
