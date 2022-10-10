package com.eve.leetcode.面试经典.medium;

import com.eve.leetcode.medium.tree.TreeNode;

/**
 * Created by Eve on 2022/9/21.
 */

/**
 * 面试题 04.10. 检查子树
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * <p>
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * <p>
 * 注意：此题相对书上原题略有改动。
 * <p>
 * 示例1:
 * <p>
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * 示例2:
 * <p>
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * 提示：
 * <p>
 * 树的节点数目范围为[0, 20000]。
 */
public class _0410_checkSubTree {

    public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        int h1 = height(t1, 0);
        int h2 = height(t2, 0);
        if(h1 < h2){
            return false;
        } else if(h1 == h2){
            return checkSame(t1,t2);
        }else {
           return checkSubTree(t1.right, t2) || checkSubTree(t1.left, t2);
        }

    }

    private static int height(TreeNode node, int height) {
        if (node == null) return height;
        return Math.max(height(node.left, height+1), height(node.right, height+1));
    }

    private static boolean checkSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val == n2.val) {
            return checkSame(n1.left, n2.left) && checkSame(n1.right, n2.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.right =  new TreeNode(3);
        t1.left =  new TreeNode(2);
        t1.left.right =  new TreeNode(4);
        t1.left.left =  new TreeNode(9);
        t1.left.left.right = new TreeNode(8);

        TreeNode t2 = new TreeNode(2);
        t2.right =  new TreeNode(4);
        t2.left =  new TreeNode(9);
        t2.left.right = new TreeNode(8);

        System.out.println(height(t1,0));
        System.out.println(height(t2,0));
        System.out.println(checkSame(t1.left,t2));
        System.out.println(checkSubTree(t1,t2));
    }
}
