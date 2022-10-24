package com.eve.leetcode.面试经典.medium;

import java.util.LinkedList;
import java.util.List;

public class _面试题0807_permutation {

    public String[] permutation(String S) {
        int len = S.length();
        boolean[] visited = new boolean[len];
        List<String> ls = new LinkedList<>();
        dfs(S,"",0,ls,visited);
        return ls.toArray(new String[ls.size()]);
    }

    private void dfs(String s, String st ,int length, List<String> ls,boolean[] visited){
        if(length == s.length()){
            ls.add(st);
        }
        for(int i = 0 ; i < s.length();i++){
           if(visited[i]) continue;
           else{
               visited[i]= true;
               dfs(s,st + s.charAt(i),length+1,ls,visited);
           }
        }
    }


}
