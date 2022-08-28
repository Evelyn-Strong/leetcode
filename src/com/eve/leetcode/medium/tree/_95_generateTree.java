package com.eve.leetcode.medium.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/8/26.
 */

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。

  

 示例 1：


 输入：n = 3
 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 示例 2：

 输入：n = 1
 输出：[[1]]
  

 提示：

 1 <= n <= 8

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/unique-binary-search-trees-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _95_generateTree {

    //二叉搜索树的特性：root的left都比root.val要小，root的right都比root.val大

    public static  List<TreeNode> generateTrees(int n) {

       List<TreeNode> [][] dp =  new LinkedList[n][n];

        return null;

    }

    private static TreeNode helper(TreeNode root, int left, int right){

        int i=left;

        int root_val = root.val;

        while(i<=right){
            if(root_val <=i+1 && root_val>=i){
                helper(root.left, left,i);
                helper(root.right, i+1,right);
            }
        }

        while(i<=right){

        }
       return null;

    }


    private static TreeNode generate(TreeNode root, int left, int right){
        if(right ==  left) return new TreeNode(left);
        for(int i = right; i<left; i++){

        }

        return null;
    }



    public static void main(String[] args) {
        List<TreeNode> ans = generateTrees(4);
        System.out.println(ans);

    }
}
