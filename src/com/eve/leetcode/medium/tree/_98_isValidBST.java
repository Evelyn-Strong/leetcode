package com.eve.leetcode.medium.tree;

import java.util.*;

/**
 * Created by Eve on 2022/8/28.
 */
public class _98_isValidBST {

    public static boolean isValidBST(TreeNode root) {

        if(root.left == null && root.right == null) return true;

        Queue<TreeNode> left = new ArrayDeque<>();
        Queue<TreeNode> right  = new ArrayDeque<>();

        if(root.left != null){
            left.offer(root.left);
            while(left.size() > 0){
                TreeNode node = left.poll();
                if(node.val < root.val){
                    if(node.left != null){
                        left.offer(node.left);
                    }
                    if(node.right != null){
                        left.offer(node.right);
                    }
                }else{
                    return false;
                }
            }
            if(!isValidBST(root.left)){
                return false;
            }
        }

        if(root.right != null){
            right.offer(root.right);
            while(right.size() > 0){
                TreeNode node = right.poll();
                if(node.val > root.val){
                    if(node.left != null){
                        right.offer(node.left);
                    }
                    if(node.right != null){
                        right.offer(node.right);
                    }
                }else{
                    return false;
                }
            }
            if(!isValidBST(root.right)){
                return false;
            }
        }

        return true;
    }


    //方法一: 递归  upper, lower
    public boolean _isValidBST(TreeNode root) {
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean _isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return _isValidBST(node.left, lower, node.val) && _isValidBST(node.right, node.val, upper);
    }

    //方法二：中序遍历 后就是一个序列递增
    public boolean __isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new  TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        System.out.println(isValidBST(root));
    }

}
