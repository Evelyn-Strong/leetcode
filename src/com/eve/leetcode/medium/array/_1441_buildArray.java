package com.eve.leetcode.medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/8.
 */

/**
 * 给你一个数组 target 和一个整数 n。每次迭代，需要从  list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * "Push"：从 list 中读取一个新元素， 并将其推入数组中。
 * "Pop"：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * 示例 2：
 * <p>
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * 示例 3：
 * <p>
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * 1 <= n <= 100
 * 1 <= target[i] <= n
 * target 严格递增
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/build-an-array-with-stack-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1441_buildArray {


    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new LinkedList<>();
        int num = 1;
        for (int i = 0; i < target.length; i++) {
            while (num != target[i]) {
                num++;
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            num++;
        }

        return ans;

    }

    public static void main(String[] args) {
        buildArray(new int[]{1,2,3}, 3);
    }

}
