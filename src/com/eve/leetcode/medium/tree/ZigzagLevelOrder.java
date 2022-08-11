package com.eve.leetcode.medium.tree;

import com.sun.tools.javac.util.*;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Eve on 2022/8/3.
 */


//Definition for a binary tree node.

public class ZigzagLevelOrder {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int deep = 0;
        dfs(root,deep,map);
        map.forEach((k,v)->{
            if(k%2==1){
                List<Integer> rv = new LinkedList<Integer>();
                for(int i =0;i<v.size();i++){
                    rv.add(v.get(v.size()-i-1));
                }
                list.add(rv);
            }else{
                list.add(v);
            }

        });
        return list;

    }

    private static Map<Integer,List<Integer>> dfs(
            TreeNode node,
            Integer deep,
            Map<Integer,List<Integer>> map){
        if(node == null){
            return map;
        }
        if(map.containsKey(deep)){
            List<Integer> list =  map.get(deep);
            list.add(node.val);
        }else{
            List<Integer> list = new LinkedList<>();
            list.add(node.val);
            map.put(deep,list);
        }
        // left  node
        if(node.left != null){
            dfs(node.left,deep+1,map);
        }
        // right node
        if(node.right !=null){
            dfs(node.right,deep+1,map);
        }
        return map;

    }

    public static void main(String[] args) {

        zigzagLevelOrder(null);

    }

}
