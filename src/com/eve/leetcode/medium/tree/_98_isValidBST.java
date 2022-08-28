package com.eve.leetcode.medium.tree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

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

    public static void main(String[] args) {
        TreeNode root = new  TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        System.out.println(isValidBST(root));
    }

}
