package com.eve.leetcode.medium.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Eve on 2022/8/16.
 */

// deserialize null as "#"
public class Serialize_Deserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "#";

        return root.val+","+serialize(root.left)+","+serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);


    }

    private TreeNode helper(Queue<String> queue){
        String val =  queue.poll();
        if("#".equals(val)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left =  helper(queue);
        root.right = helper(queue);
        return root;

    }


}
