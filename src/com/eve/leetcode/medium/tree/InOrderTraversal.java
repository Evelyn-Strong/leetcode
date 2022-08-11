package com.eve.leetcode.medium.tree;
/**
*
* Created by Eve on 2022/8/3.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class InOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null ) return new ArrayList<>();
        return dfs(root,new LinkedList<>());
    }

    private static List<Integer> dfs(TreeNode node, List<Integer> result){
        if(node == null) return result;
        //add left tree node
        if(node.left != null){
            dfs(node.left, result);
        }
        //add middle node value
        result.add(node.val);

        //add right tree node
        if(node.right !=null){
            dfs(node.right, result);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
