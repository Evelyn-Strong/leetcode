package com.eve.leetcode.medium.list;

/**
 * Created by Eve on 2022/8/13.
 */
public class _328_OddEvenList {
    //双指针
    //但注意listNode的值传递
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode _odd = odd;
        ListNode _even = even;
        int index = 0;
        while(head != null){
            if(index % 2 == 0){
                odd.next = head;
                odd = odd.next;
            }else{
                even.next = head;
                even = even.next;
            }
            head = head.next;
            index++;
        }
        even.next = null;
        odd.next = _even.next;
        return _odd.next;
    }

    public static void main(String[] args) {

    }

}
