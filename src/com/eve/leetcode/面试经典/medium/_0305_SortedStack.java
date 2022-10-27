package com.eve.leetcode.面试经典.medium;

import java.util.Stack;

public class _0305_SortedStack {

    Stack<Integer> sortedSt;
    Stack<Integer> tmp;
    int size;

    public _0305_SortedStack() {
        size = 0;
        sortedSt = new Stack<>();
        tmp = new Stack<>();
    }

    public void push(int val) {
/*        if (size == 0) {
            sortedSt.push(val);
        } else {
            while (val > sortedSt.peek()) {
                tmp.push(sortedSt.pop());
            }
            sortedSt.push(val);
            while (tmp.size() > 0) {
                sortedSt.push(tmp.pop());
            }
        }
        size++;*/

        sort(val);
        size++;
    }

    private void sort(int val) {

        if(sortedSt.isEmpty() || sortedSt.peek() >= val){
            sortedSt.push(val);
            return;
        }else{
            int tmp = sortedSt.pop();
            sort(val);
            sortedSt.push(tmp);
        }
    }

    public void pop() {
        sortedSt.pop();
        size--;
    }

    public int peek() {
        return sortedSt.peek();
    }

    public boolean isEmpty() {
        return size == 0;

    }
}
