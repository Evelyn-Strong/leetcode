package com.eve.leetcode.competition;

import com.eve.leetcode.medium.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _20221113 {

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + new Double(273.15);
        double fahrenheit = celsius * new Double(1.80) + new Double(32.00);
        return new double[]{kelvin, fahrenheit};
    }


    public static int subarrayLCM(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            if (n != 0 && k % n == 0) nums[i] = k / n;
            else nums[i] = -1;
        }
        if (nums[0] == -1) dp[0] = -1;
        else dp[0] = (nums[0] == 1) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == -1) dp[i] = -1;
            else{
                if (dp[i - 1] == 0) {
                    if (nums[i-1]!= -1 &&  nums[i]==1 || !(nums[i] % nums[i - 1] == 0 || nums[i - 1] % nums[i] == 0)) {
                        dp[i] = 1 + (nums[i]==1?1:0);
                    }
                } else if (dp[i - 1] > 0) {
                    int step = 0;
                    while (step <= dp[i - 1] && i - step - 1 >= 0) {
                        if (nums[i - step - 1] == 1 || (nums[i - step - 1] != -1 && !(nums[i] % nums[i - step - 1] == 0 || nums[i - step - 1] % nums[i] == 0)))
                            step++;
                        else break;
                    }
                    dp[i] = step+(nums[i]==1?1:0);
                }
            }
        }
        int sum = 0;
        for (int count : dp) {
            if (count != -1) {
                sum += count;
            }
        }

        return sum;
    }


    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans += miniumChange(queue);
        }
        return ans;
    }


    public int miniumChange(Queue<TreeNode> queue) {

        int len = queue.size();
        if (len == 0) return 0;
        Integer[] arr = new Integer[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            arr[idx] = queue.poll().val;
        }
        Integer[] sorted = Arrays.copyOf(arr, len);
        Arrays.sort(sorted);

        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(convertTemperature(new Double(36.50)));
        System.out.println(subarrayLCM(new int[]{3}, 2));
    }
}
