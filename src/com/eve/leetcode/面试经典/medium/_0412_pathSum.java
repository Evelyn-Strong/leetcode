package com.eve.leetcode.面试经典.medium;

import com.eve.leetcode.medium.tree.TreeNode;

public class _0412_pathSum {

    public static int pathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private static int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return psum(root, sum) + dfs(root.left, sum) + dfs(root.right, sum);
    }

    private static int psum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return sum == root.val ? 1 : 0;
        } else {
            if (sum == root.val) return 1 + psum(root.left, sum - root.val) + psum(root.right, sum - root.val);
            else return psum(root.left, sum - root.val) + psum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(-4);

        root.right = new TreeNode(4);
        System.out.println(pathSum(root, 9));
    }

}
