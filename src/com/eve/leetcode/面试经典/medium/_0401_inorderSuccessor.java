package com.eve.leetcode.面试经典.medium;

import com.eve.leetcode.medium.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */
public class _0401_inorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
       List<TreeNode> ls = new LinkedList<>();
       dfs(root,ls);
       boolean matched =  false;
       for(TreeNode node: ls){
           if(matched){
               return node;
           }
           if( node == p ) matched = true;
       }
       return null;
    }
    private void dfs(TreeNode root, List<TreeNode> ls){
        if(root == null) return;
        dfs(root.left, ls);
        ls.add(root);
        dfs(root.right,ls);
    }


    //二叉搜索树特性

//    public TreeNode _inorderSuccessor(TreeNode root, TreeNode p) {
//
//    }
//
//
//    private void dfs(TreeNode root, TreeNode p,List<TreeNode> ls){
//        if(root == null) return;
//        if(root.val > p.val){
//            dfs(root.left, ls);
//        }
//
//        ls.add(root);
//        dfs(root.right,ls);
//    }


}
