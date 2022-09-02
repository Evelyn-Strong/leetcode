package com.eve.leetcode.medium.array;

import java.util.Stack;

/**
 * Created by Eve on 2022/8/31.
 */
public class _946_validateStackSequences {
    //解题思路：
    //单调栈

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack =  new Stack<>();
        stack.push(pushed[0]);
        int index = 1;
        for(int i = 0; i < popped.length ; i++ ){
            while((stack.isEmpty() || !stack.isEmpty() && stack.peek() != popped[i] ) && index < pushed.length){
                stack.push(pushed[index]);
                index++;
            }

            while(!stack.isEmpty() && stack.peek() == popped[i]){
               stack.pop();
            }
        }
        return stack.size()==0? true:false;
    }

    public static void main(String[] args) {
        int[] pushed =  new int[]{1,0};
        int[] popped =  new int[]{1,0};

        System.out.println(validateStackSequences(pushed,popped));
    }
}
