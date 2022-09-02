package com.eve.leetcode.medium.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Eve on 2022/8/29.
 */
public class _148_sortList {

    public ListNode sortList(ListNode head) {
        List<ListNode> ls = new LinkedList<>();
        while(head.next != null){
            if(head.val> head.next.val){
                head.next = null;

            }
        }

      return null;//TODO
    }


}
