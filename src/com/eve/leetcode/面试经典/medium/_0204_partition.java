package com.eve.leetcode.面试经典.medium;

import com.eve.leetcode.medium.list.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/21.
 */

/**
 * 面试题 02.04. 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class _0204_partition {

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        if (head == null) return head;
        while(head != null){
            if(head.val<x){
                small.next = new ListNode(head.val);
                small = small.next;
            }else{
                large.next = new ListNode(head.val);
                large = large.next;
            }
            head =  head.next;
        }

        small.next = largeHead.next;
        return smallHead.next;

    }


    public static void main(String[] args) {
//        ListNode head  = new ListNode(1);
//        head.next =  new ListNode(4);
//        head.next.next =  new ListNode(3);
//        head.next.next.next =  new ListNode(2);
//        head.next.next.next.next =  new ListNode(5);
//        head.next.next.next.next.next =  new ListNode(2);

        ListNode head  = new ListNode(2);
        head.next =  new ListNode(1);


        partition(head,2);

    }
}
