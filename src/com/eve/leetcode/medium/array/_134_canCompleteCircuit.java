package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/9/23.
 */
public class _134_canCompleteCircuit {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = gas[i] - cost[i];
        }
        if( len == 1) {
            return left[0]>=0? 0:-1;
        }
        int i = 0;
        while (i < len) {
            if (left[i] < 0 || (left[i] == 0 && gas[i] == 0) ) {
                i++;
                continue;
            } else {
                int start = i;
                int sum = 0;
                boolean loop = false;
                while (!((i > 0 && start == i - 1) || (i == 0 && start == len - 1))) {
                    sum += left[start];
                    if (sum < 0) break;
                    else {
                        loop = true;
                        if (start == len - 1) {
                            start = 0;
                        } else {
                            start++;
                        }
                    }
                }
                if ((i == (start + 1) || (i == 0 && start == len - 1)) && loop) {
                    if (sum + left[start] >= 0) return i;
                    else return -1;
                }
            }

            i++;
        }

        return -1;
    }


    public int _canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    //数学
    //https://leetcode.cn/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
    public int __canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }


    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
