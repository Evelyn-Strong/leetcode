package com.eve.leetcode.hard;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BinaryOperator;

/**
 * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 * <p>
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * <p>
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,0,1,1]
 * 输出：[-1,-1]
 * 示例 3:
 * <p>
 * 输入：arr = [1,1,0,0,1]
 * 输出：[0,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 3 * 104
 * arr[i] 是 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _927_threeEgualParts {

    public static int[] threeEqualParts(int[] arr) {
        int len = 0;
        for (int i : arr) {
            if (i == 1) len++;
        }
        if (len == 0) return new int[]{0, arr.length - 1};
        if (len % 3 != 0) return new int[]{-1, -1};
        else {
            int count = len / 3;
            int index = arr.length - 1;
            while (count > 0) {
                if (arr[index] == 1) {
                    count--;
                }
                index--;
            }
            String s = "";
            String part = "";
            for (int i = 0; i < arr.length; i++) {
                s += arr[i];
                if (i > index) {
                    part += arr[i];
                }
            }
            int partlen = part.length();
            int i = s.indexOf(part) + partlen - 1;
            s = s.substring(i + 1, arr.length);
            if (!s.contains(part)) return new int[]{-1, -1};
            int j = s.indexOf(part) + partlen + i + 1;
            if (i != j - partlen && j <= arr.length - partlen && s.substring(s.indexOf(part) + partlen, s.length()).contains(part)) {
                return new int[]{i, j};
            } else return new int[]{-1, -1};

        }

    }
    //TODO 三指针：
    //思路： 找到part， 找到三个二进制数的起始位置，然后三个指针逐步加1，进行对比。

    public static void main(String[] args) {
        //threeEqualParts(new int[]{1, 0, 1, 0, 1});
        //threeEqualParts(new int[]{1,0,1,1,0});
        threeEqualParts(new int[]{1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1});
        threeEqualParts(new int[]{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1});
    }
}
