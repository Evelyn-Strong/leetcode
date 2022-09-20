package com.eve.leetcode.competition;

import java.util.*;


/**
 * Created by Eve on 2022/9/11.
 */
public class _20220911_1 {

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
        }
        if (map.size() == 0) return -1;
        int maxfreq = 0;
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxfreq) {
                ans = entry.getKey();
                maxfreq = entry.getValue();
            } else if (entry.getValue() == maxfreq) {
                ans = Math.min(ans, entry.getKey());
            }

        }
        return ans;
    }


    public static int partitionString(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        int i = 0;
        Set<String> set = new HashSet<>();
        while (i < ch.length) {
            if (set.contains(ch[i] + "")) {
                set = new HashSet<>();
                count++;
                set.add(ch[i] + "");
            } else {
                set.add(ch[i] + "");
            }

            if (i == ch.length - 1) {
                count++;
            }
            i++;
        }

        return count;
    }

    public static int minGroups(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] == interval2[0]) {
                    return interval1[1] - interval2[1];
                } else {
                    return interval1[0] - interval2[0];
                }
            }
        });
        List<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            for (int j = 0; j < res.size(); j++) {
                int[] stored = res.get(j);
                if (intervals[i][0] > stored[1]) {
                    res.add(j, intervals[i]);
                    res.remove(stored);
                }
            }
            if (!res.contains(intervals[i])) {
                res.add(intervals[i]);
            }

        }

        return res.size();

    }


    public static int lengthOfLIS(int[] nums, int k) {

        int[] dp = new int[nums.length];
        int[] maxV = new int[nums.length];
        maxV[0] = 1;
        Arrays.fill(dp, 1);
        int max = maxV[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] > 0 && nums[i] - nums[j] <= k) {
                    if (dp[j] == maxV[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        break;
                    } else {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            max = Math.max(dp[i], max);
            maxV[i] = max;
        }


        return maxV[nums.length - 1];

    }


    //findMedianSortedArrays

    public static void main(String[] args) {
        //System.out.println(mostFrequentEven(new int[]{29,47,21,41,13,37,25,7}));
        //System.out.println(mostFrequentEven(new int[]{0}));
        //System.out.println(partitionString("abacaba"));
//        System.out.println(minGroups(new int[][]{
//                {229966, 812955},{308778, 948377},{893612, 952735},{395781, 574123},{478514, 875165},{766513, 953839},{
//        460683, 491583},{133951, 212694},{376149, 838265},{541380, 686845},{461394, 568742},{804546, 904032},{
//        422466, 467909},{557048, 758709},{680460, 899053},{110928, 267321},{470258, 650065},{534607, 921875},{
//        292993, 994721},{645020, 692560},{898840, 947977},{33584, 330630},{903142, 970252},{17375, 626775},{
//        804313, 972796},{582079, 757160},{785002, 987823},{599263, 997719},{486500, 527956},{566481, 813653},{
//        211239, 863969},{808577, 883125},{21880, 516436},{264747, 412144},{327175, 772333},{984807, 988224},{
//        758172, 916673},{23583, 406006},{954674, 956043},{379202, 544291},{688869, 785368},{841735, 983869},{
//        99836, 916620},{332504, 740696},{740840, 793924},{896607, 920924},{868540, 922727},{125849, 550941},{
//        433284, 685766}}));


        //System.out.println(minGroups(new int[][]{{6, 7}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
        // System.out.println(lengthOfLIS(new int[]{1,15}, 1));
    }
}
