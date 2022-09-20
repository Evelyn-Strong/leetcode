package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/9/8.
 */
public class _667_constructArray {

    //脑筋急转弯：
    //从特殊情况开始分析：
    //当k=1时；（1,2,3...n）
    //当k=n时： (1,n,2,n-1,3,n-2....,i,n-i) (i为中间下标数)
    //so：当k为某个值（x）时（1～x）用k=1的情况排列，后面用k=n的情况排列 （or 反过来）
    public static int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; ++i) {
            answer[idx] = i;
            ++idx;
        }
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            answer[idx] = i;
            ++idx;
            if (i != j) {
                answer[idx] = j;
                ++idx;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(constructArray(5, 1));
    }
}
