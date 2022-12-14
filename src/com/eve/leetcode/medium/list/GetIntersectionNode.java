package com.eve.leetcode.medium.list;


/**
 * Created by Eve on 2022/8/14.
 */
public class GetIntersectionNode {
    //链表
    //1。双指针， acur & bcur 走相交前（a+b）+ 相交后的共同距离
    //2。两个链表距离相减， 从同一个起始点开始对比元素是否相同

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode newA = headA;
        ListNode newB = headB;
        int alen = 0;
        int blen = 0;
        while(headA !=  null || headB != null){
            if(headA != null){
                alen++;
                headA =  headA.next;
            }

            if(headB != null){
                blen++;
                headB = headB.next;
            }


        }

        if(alen-blen>=0){
            int n = alen-blen;
            while(n-->0){
                newA = newA.next;
            }
            while(newA!= null){
                if(newA == newB){
                    return newA;
                }else{
                    newA =  newA.next;
                    newB =  newB.next;
                }
            }
        }

        if(alen-blen< 0){
            int n = blen-alen;
            while(n-->0){
                newB = newB.next;
            }
            while(newA != null){
                if(newA == newB){
                    return newA;
                }else{
                    newA =  newA.next;
                    newB =  newB.next;
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode  a =  new ListNode(1);
        ListNode  a1 =  new ListNode(2);
        ListNode  a2 =  new ListNode(1);
        ListNode  a3 =  new ListNode(0);
        a.next =  a1;
        a1.next = a2;
        a2.next = a3;

        ListNode  b =  new ListNode(4);
        ListNode  b1 =  new ListNode(1);
        ListNode  b2 =  new ListNode(3);
        b.next =  b1;
        b1.next = b2;

        System.out.println(getIntersectionNode(a,b).val);


    }
}
