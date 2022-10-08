package com.eve.leetcode.面试经典.medium;

import java.util.*;

public class _0303_StackOfPlates {

    List<List<Integer>> ls;
    int cap;
    int size;

    public _0303_StackOfPlates(int cap) {
        ls = new LinkedList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if(cap == 0 ) return;
        size++;
        if (ls.size() == 0) {
            ls.add(new ArrayList<>(Arrays.asList(new Integer[]{val})));
        } else {
            List<Integer> stack = ls.get(ls.size() - 1);
            if (stack.size() == cap) {
                ls.add(new ArrayList<>(Arrays.asList(new Integer[]{val})));
            } else {
                stack.add((Integer) val);
            }
        }

    }

    public int pop() {
        if(ls.size() == 0) return -1;
        size--;
        List<Integer> stack = ls.get(ls.size() - 1);
        int ans = stack.get(stack.size() - 1);
        if(stack.size() == 1){
            ls.remove(ls.size() -1);
        }else{
            stack.remove(stack.size() - 1);
        }

        if (stack.size() == 0) {
            ls.remove(stack);
        }
        return ans;
    }

    public int popAt(int index) {
        int ans = 0;
        if( index > ls.size()-1) return -1;
        else{
            List<Integer> stack =  ls.get(index);
            ans = stack.get(stack.size() - 1);
            if(stack.size() == 1){
                ls.remove(index);
            }else{
                stack.remove(stack.size() - 1);
            }

            if (stack.size() == 0) {
                ls.remove(stack);
            }
        }
        size--;
        return ans;
    }


    public static void main(String[] args) {
        _0303_StackOfPlates obj = new _0303_StackOfPlates(1);
        obj.push(7);
        obj.push(3);
        obj.push(7);
        obj.push(8);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
//        int param_2 = obj.popAt(0);
//        int param_21 = obj.popAt(0);
//        int param_22 = obj.popAt(0);
    }

}


