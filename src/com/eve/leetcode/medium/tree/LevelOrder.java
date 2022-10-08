package com.eve.leetcode.medium.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Eve on 2022/8/16.
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        List<List<Integer>> result =  new LinkedList<>();

        if(root == null) return null;

        queue.offer(root);
        level(queue,result);

        return result;

    }

    private void level(Queue<TreeNode> queue , List<List<Integer>> result){

        List<Integer> list = new LinkedList<>();
        int size = queue.size();

        if(queue.size() == 0) return;

        while(size>0){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
            size--;
        }
        result.add(list);
        level(queue,result);
    }
}
