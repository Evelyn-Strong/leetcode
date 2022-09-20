package com.eve.leetcode.面试经典.medium;

import com.eve.leetcode.medium.list.ListNode;

/**
 * Created by Eve on 2022/9/14.
 */

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0205_addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode ans = new ListNode();
        head.next = ans;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (flag) sum++;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                flag = true;
                ans.next = new ListNode(sum - 10);
                ans = ans.next;
            } else {
                ans.next = new ListNode(sum);
                ans = ans.next;
                flag = false;
            }

        }
        //carry = 进位
        if (flag) {
            ans.next = new ListNode(1);
        }
        head = head.next.next;
        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next =  new ListNode(4);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(2);
        l2.next =  new ListNode(6);
        l2.next.next = new ListNode(6);

        System.out.println(addTwoNumbers(l1,l2));
    }
}
