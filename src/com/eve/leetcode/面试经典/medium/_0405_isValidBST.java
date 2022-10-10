package com.eve.leetcode.面试经典.medium;

import com.eve.leetcode.medium.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/21.
 */
public class _0405_isValidBST {


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        List<Integer> ls = new LinkedList<>();
        dfs(root, ls);
        Integer[] nums = ls.toArray(new Integer[ls.size()]);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]>=nums[i]) return false;
        }

        return true;

    }

    private void dfs(TreeNode root, List<Integer> ls) {

        if (root == null) return;
        dfs(root.left, ls);
        ls.add(root.val);
        dfs(root.right, ls);

    }
}
