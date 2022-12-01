package com.eve.leetcode.medium.array;

public class _754_reachNumber {
    //解体思路：贪心=》 每个move 可正可负， 当和最先等于target的时候为
    public int reachNumber(int target) {
        target = Math.abs(target);
        int pos = 0;
        int i = 1;
        while (target > pos + i) {
            pos += i;
            i++;
        }
        if ((i + pos - target) < (target - pos)) {
            return i + (i + pos - target) * 2;
        } else {
            return i + (target - pos) * 2 - 1;
        }
    }
}
