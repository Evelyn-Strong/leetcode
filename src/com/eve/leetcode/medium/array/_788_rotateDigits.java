package com.eve.leetcode.medium.array;

import java.util.*;

/**
 * Created by Eve on 2022/9/25.
 * 788. 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 的取值范围是 [1, 10000]。
 */
public class _788_rotateDigits {
    List<Integer> ls = new LinkedList<>();
    List<Integer> ls2 = new LinkedList<>();

    {
        ls.addAll(Arrays.asList(new Integer[]{0, 1, 2, 5, 6, 8, 9}));
        ls2.addAll(Arrays.asList(new Integer[]{2, 5, 6, 9}));
    }

    public int rotatedDigits(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + isValidRotateDigit(i);
        }

        return dp[n];

    }

    private int isValidRotateDigit(int x) {
        if (x < 10) {
            return ls2.contains(x) ? 1 : 0;
        }
        String ns = String.valueOf(x);
        char[] ch = ns.toCharArray();
        int len = ch.length;
        if (ch[0] == 0 ) return 0;
        for (int i = 0; i < len; i++) {
           if(!ls.contains(ch[i])) return 0;
        }
         return 1;
    }
}
