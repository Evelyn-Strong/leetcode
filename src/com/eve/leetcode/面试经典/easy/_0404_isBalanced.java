package com.eve.leetcode.面试经典.easy;

import com.eve.leetcode.medium.tree.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Eve on 2022/9/20.
 */

/**
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class _0404_isBalanced {


    public static boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        if (root.right == null && root.left == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.right) && isBalanced(root.left);


    }

    //bfs
    private static int depth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int size = queue.size();
        int depth = 0;

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            size--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (size == 0) {
                size = queue.size();
                depth++;
            }
        }
        return depth;
    }


   //dfs (height dfs 计算)
    private static int _depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(_depth(root.left),_depth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println(isBalanced(root));
    }
}
