package com.eve.leetcode.easy;

/**
 * Created by Eve on 2022/9/9.
 */
public class _1598_minOperations {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (int i = 0; i< logs.length; i++){
            String operation = logs[i];
            if(operation.equals("./")){
                continue;
            }else if(operation.equals("../")){
                if(depth != 0){
                    depth--;
                }
            }else{
               depth++;
            }
        }

        return depth;

    }
}
