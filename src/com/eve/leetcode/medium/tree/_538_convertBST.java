package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/8/28.
 */
public class _538_convertBST {

    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {

        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        convertBST(root);
        System.out.println(1);
    }

}
