package com.eve.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/11.
 */
public class _647_countSubstrings {

    //枚举法
    //时间复杂度O（n^3）
    public static int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int ans = 0;

        for (int i = 0; i < ch.length; i++) {
            int left = i - 1;
            ans++;
            while (left >= 0) {
                if (isSymetric(Arrays.copyOfRange(ch, left, i + 1))) ans++;
                left--;
            }
        }

        return ans;
    }

    private static boolean isSymetric(char[] s) {

        int len = s.length;
        int i = 0;

        while (i <= len / 2 - 1) {
            if (s[i] != s[len - 1 - i]) return false;
            i++;
        }
        return true;
    }


    //解法二：
    //中心拓展法(奇偶同循环判断回文)
    //枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展。
    //枚举回文中心的是 O(n)O(n) 的，对于每个回文中心拓展的次数也是 O(n)O(n) 的，所以时间复杂度是 O(n^2)

    /**
     * 在实现的时候，我们需要处理一个问题，即如何有序地枚举所有可能的回文中心，我们需要考虑回文长度是奇数和回文长度是偶数的两种情况。
     * 如果回文长度是奇数，那么回文中心是一个字符；如果回文长度是偶数，那么中心是两个字符。
     * 当然你可以做两次循环来分别枚举奇数长度和偶数长度的回文，但是我们也可以用一个循环搞定。
     * 我们不妨写一组出来观察观察，假设 n = 4，我们可以把可能的回文中心列出来：
     * <p>
     * 编号 i	回文中心左起始位置 li 回文中心右起始位置 ri
     * ​
     * i    li  ri
     * 0	0	0
     * 1	0	1
     * 2	1	1
     * 3	1	2
     * 4	2	2
     * 5	2	3
     * 6	3	3
     * 由此我们可以看出长度为 n 的字符串会生成 2n-1 组回文中心组。
     * 这样我们只要从 0 到 2n - 2遍历 i，就可以得到所有可能的回文中心，这样就把奇数长度和偶数长度两种情况统一起来了。
     **/
    public static int _countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int ans = 0;
        int len = ch.length;
        if(len == 1) return 1;

        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i/2;
            int r = i/2+i%2;
            while(r<len && l>=0 && s.charAt(l)==s.charAt(r)){
                    r++;
                    l--;
                    ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(_countSubstrings("aa"));
    }
}
