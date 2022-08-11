package com.eve.leetcode.medium.tree;

import java.util.Arrays;

/**
 * Created by Eve on 2022/8/3.
 */
public class BuildTree_InO_PreO {

    //解题思路：
    //preorder to get rootNode
    //inorder to get leftNode and rightNode
    //inOrder and  PreOrder do not have duplicated element

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Integer deep = 0;
        TreeNode node = new TreeNode(preorder[deep]);
        dfsBuildTree(deep,preorder,inorder,null);
        return node;

    }

    public TreeNode dfsBuildTree(Integer deep, int[] preorder, int[] inorder, TreeNode node){

        if(deep>=preorder.length){
            return node;
        }else{
            //add node
            if(node == null){
                node =  new TreeNode(preorder[deep]);
            }else{
                TreeNode left = new TreeNode(preorder[deep]);
                node.left = left;
                node = node.left;
            }



        }
        //then split inorder
        if(inorder == null) return node;
        //find preorder element in inorder array, then split to left inorder array and right inorder array.
        int idx=0;
        while(idx<inorder.length){
            if(inorder[idx] == preorder[deep]) {
                break;
            }
            idx++;
        }

        int[] leftinorder = idx==0?null:Arrays.copyOfRange(inorder,0,idx-1);
        int[] rightinorder = idx==inorder.length-1?null:Arrays.copyOfRange(inorder,idx+1,inorder.length-1);

        if(leftinorder.length == 1){
            node.left =  new TreeNode(leftinorder[0]);
            deep++;
        }else{
            //left
            node.left = dfsBuildTree(deep++,preorder,leftinorder,node);
        }
        if(rightinorder.length == 1){
            node.right = new TreeNode(rightinorder[0]);
            deep++;
        }else {
            //right
            node.right = dfsBuildTree(deep++, preorder, rightinorder, node);
        }

        return node;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
