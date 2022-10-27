package com.eve.leetcode.面试经典.medium;

/**
 * 面试题 16.01. 交换数字
 * 中等
 * 79
 * 相关企业
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 *
 * numbers.length == 2
 * -2147483647 <= numbers[i] <= 2147483647
 */
public class _面试题1601_swapNumbers {

    //不用临时变量
    // 解题思路：异或
    // a^a^b = b; b^b^a = a
    public int[] swapNumbers(int[] numbers) {
        numbers[1] = numbers[0]^numbers[1];
        numbers[0] = numbers[0]^numbers[1];
        numbers[1] = numbers[0]^numbers[1];
        return numbers;
    }
}
