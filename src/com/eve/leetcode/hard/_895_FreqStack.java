package com.eve.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _895_FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> group;
    int maxFreq;

    public _895_FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int newfreq = freq.get(val);
        group.putIfAbsent(newfreq, new ArrayDeque<>());
        group.get(newfreq).push(val);
        maxFreq = Math.max(newfreq,maxFreq);
    }

    public int pop() {
        int popVal = group.get(maxFreq).peek();
        group.get(maxFreq).pop();
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        freq.put(popVal, freq.get(popVal) - 1);
        return popVal;
    }
}
