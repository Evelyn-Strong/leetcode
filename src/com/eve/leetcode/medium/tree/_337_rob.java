package com.eve.leetcode.medium.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Eve on 2022/9/21.
 */
public class _337_rob {
    //bfs
    public int rob(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) return 0;
        q.offer(root);
        int depth = 0;
        int sum = 0;
        int size = q.size();
        List<Integer> ls = new LinkedList<>();
        while (q.size() > 0) {
            TreeNode node = q.poll();

            sum += node.val;

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
            size--;
            if (size == 0) {
                ls.add(depth,sum);
                size = q.size();
                depth++;
                sum = 0;
            }
        }
        Integer[] nums = ls.toArray(new Integer[depth-1]);
        int[] dp = new int[nums.length];
        if(nums.length == 1) {
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[1],nums[0]);
        }else{
            dp[0] = nums[0];
            dp[1] = Math.max(nums[1],nums[0]);

            for(int i = 2 ; i < nums.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            return dp[nums.length-1];
        }
    }
}
