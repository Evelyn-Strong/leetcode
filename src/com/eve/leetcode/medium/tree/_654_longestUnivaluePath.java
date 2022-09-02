package com.eve.leetcode.medium.tree;

import java.util.*;

/**
 * Created by Eve on 2022/9/2.
 * https://leetcode.cn/problems/longest-univalue-path/
 */
public class _654_longestUnivaluePath {

    static Integer ans;
    //dfs
    public  static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;

    }

    public static int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = 0, r = 0;
        int nl = dfs(node.left), nr = dfs(node.right);
        if (node.left != null && node.val == node.left.val) {

            l = 1 + nl;
        }
        if (node.right != null && node.val == node.right.val) {
            r = 1 + nr;
        }
        ans = Math.max(ans, r + l);
        return Math.max(l, r);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left =  new TreeNode(5);
        root.right =  new TreeNode(5);
        root.right.left =  new TreeNode(1);
        root.right.right =  new TreeNode(5);

        System.out.println(longestUnivaluePath(root));

    }
}
