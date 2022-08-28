package com.eve.leetcode.medium.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/8/26.
 */
public class _114_flatten {


    public static void flatten(TreeNode root) {
        if(root == null || (root.left==null && root.right == null)) return;

         TreeNode ans = null;
         TreeNode tmp = null;

         List<Integer> ls = new LinkedList<>();
         helper(root,ls);

         for(int i : ls){
             if(ans == null){
                 ans = new TreeNode(i);
                 tmp = ans;
             }else{
                 ans.left = null;
                 ans.right = new TreeNode(i);
                 ans =  ans.right;
             }

         }

          root.right = tmp.right;
          root.left = tmp.left;

    }

    private static void helper(TreeNode root , List<Integer> ls){
        if(root == null) return;
        ls.add(root.val);
        helper(root.left,ls);
        helper(root.right,ls);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        root.left =  new TreeNode(2);
        root = root.left;
        root.left =  new TreeNode(3);
        root.right =  new TreeNode(4);

        flatten(node);
        System.out.println(1);
    }


}
