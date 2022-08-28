package com.eve.leetcode.medium.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Eve on 2022/8/17.
 */
public class _1302_DeepestLeaveSum {

    //bfs
    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        return bfs(queue,0);
    }

    private int bfs(Queue<TreeNode> queue, int result){
        if(queue.size()==0) return result;
        int size = queue.size();
        int sum = 0;
        while(size>0){
            TreeNode root = queue.poll();
            sum += root.val;
            if(root.left != null) queue.offer(root.left);
            if(root.right != null) queue.offer(root.right);
            size--;
        }
        result = sum;
        return bfs(queue,result);
    }
}
