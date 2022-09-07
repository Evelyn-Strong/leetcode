package com.eve.leetcode.medium.tree;

import java.util.*;

/**
 * Created by Eve on 2022/9/5.
 */
public class _652_findDuplicateSubtrees {


    Map<String,Integer> map =  new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    //序列化（DFS+哈希表）
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        TreeNode head = new TreeNode();
        dfs(root);
        return new LinkedList<>(repeat);

    }

    private String dfs(TreeNode root){

        if(root== null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(dfs(root.left));
        sb.append(")(");
        sb.append(dfs(root.right));
        sb.append(")");
        if(map.containsKey(sb.toString())){
            repeat.add(root);
            map.remove(sb.toString());
        }else{
            map.put(sb.toString(),root.val);
        }
        return sb.toString();
    }


}
