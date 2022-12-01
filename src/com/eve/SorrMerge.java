package com.eve;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SorrMerge {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> sorted = intervals.stream().sorted(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) return o1.start - o2.start;
                else return o1.end - o2.end;
            }
        }).collect(Collectors.toList());
        Stack<Interval> stack = new Stack<>();

        stack.push(sorted.get(0));
        for (int i = 1; i < sorted.size(); i++) {

                Interval interval1 = stack.pop();
                Interval interval2 = sorted.get(i);
                if(interval1.end >= interval2.start){
                    if(interval1.end <= interval2.end){
                        stack.push(new Interval(interval1.start, interval2.end));
                    }else{
                        stack.push(new Interval(interval1.start, interval1.end));
                    }

                }else {
                    stack.push(interval1);
                stack.push(interval2);
                }
        }
       return new ArrayList<>(sorted);
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
