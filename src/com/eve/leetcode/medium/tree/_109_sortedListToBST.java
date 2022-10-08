package com.eve.leetcode.medium.tree;

import com.eve.leetcode.medium.list.ListNode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: head = [-10,-3,0,5,9]
 * 输出: [0,-3,9,-10,null,5]
 * 解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 示例 2:
 * <p>
 * 输入: head = []
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * head 中的节点数在[0, 2 * 104] 范围内
 * -105 <= Node.val <= 105
 */
public class _109_sortedListToBST {

    //解题思路：
    //找到中位数然后分左右BST 再迭代
    public static TreeNode sortedListToBST(ListNode head) {
        ListNode left = new ListNode();
        left.next = head;
        int len = 0;
        while (left.next != null) {
            left = left.next;
            len++;
        }
        if (len == 1) {
            return new TreeNode(head.val);
        } else if (len == 2) {
            TreeNode root = new TreeNode(head.val);
            head = head.next;
            root.left = null;
            root.right = new TreeNode(head.val);
            return root;
        } else if (len > 2) {
            left = new ListNode();
            left.next = head;
            int mid = len / 2;
            while (mid - 1 > 0) {
                head = head.next;
                mid--;
            }
            TreeNode root = new TreeNode(head.next.val);
            root.right = sortedListToBST(head.next.next);
            head.next = null;
            root.left = sortedListToBST(left.next);
            return root;
        }
        return null;
    }

    //优化用快慢指针找到中位数
    public static TreeNode _sortedListToBST(ListNode head) {
        if (head == null) return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            pre = pre.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right =  _sortedListToBST(slow.next);
        pre.next = null;
        root.left = _sortedListToBST(head);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next = new ListNode(10);

        _sortedListToBST(head);
    }
}
