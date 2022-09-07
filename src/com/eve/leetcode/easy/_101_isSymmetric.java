package com.eve.leetcode.easy;

import com.eve.leetcode.medium.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Eve on 2022/9/5.
 */
public class _101_isSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if(!(root.left != null && root.right!=null)){
            if(root.left == null && root.right == null){
                return true;
            }else{
                return false;
            }
        }

       return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode node1 , TreeNode node2){
        if(node1==null && node2 == null) return true;
        if(node1 == null || node2 == null ) return false;
        if(node1.val == node2.val){
            return dfs(node1.left,node2.right) && dfs(node1.right,node2.left);

        }else{
            return false;
        }
    }
}
