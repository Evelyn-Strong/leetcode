package com.eve.leetcode.easy;

import com.eve.leetcode.medium.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Eve on 2022/9/5.
 */
public class _104_maxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        int ans = 1;
        q.offer(root);
        helper(ans,q);
        return ans;

    }

    private void helper(int depth, Queue<TreeNode> q){
        if(q.size()==0) return;
        int size = q.size();
        while (size>0){
           TreeNode node =  q.poll();
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
            size--;
        }
        depth++;
        helper(depth,q);

    }
}
