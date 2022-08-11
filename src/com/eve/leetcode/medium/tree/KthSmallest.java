package com.eve.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eve on 2022/8/4.
 *
 * https://baike.baidu.com/item/二叉搜索树/7077855?fr=aladdin
 *
 */

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。


public class KthSmallest {

    //二叉搜索树 中序遍历就是从小到大遍历， 那么当遍历到第k个就是需要找的数

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> result = new ArrayList<>();
        dfs(root,result);
        return result.get(k-1);


    }
    private void dfs(TreeNode node, List<Integer> result){

       //left
        if(node.left!=null){
            dfs(node.left,result);
        }

        //middle
        result.add(node.val);

        //right
        if(node.right!=null){
            dfs(node.right,result);
        }
    }

}
