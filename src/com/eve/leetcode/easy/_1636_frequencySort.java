package com.eve.leetcode.easy;

import java.util.*;

/**
 * Created by Eve on 2022/9/19.
 */
public class _1636_frequencySort {

    public static int[] frequencySort(int[] nums) {
        if(nums.length==1) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Map<Integer, String> sorted = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (sorted.containsKey(entry.getValue())) {
                sorted.put(entry.getValue(), sorted.get(entry.getValue()) + "," + entry.getKey());
            } else {
                sorted.put(entry.getValue(), entry.getKey() + "");
            }

        }
        int[] sortArray = new int[sorted.size()];
        int idx = 0;
        for (Map.Entry<Integer, String> entry : sorted.entrySet()) {
            sortArray[idx] = entry.getKey();
            idx++;
        }
        Arrays.sort(sortArray);
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < sortArray.length; i++) {
            String[] tmp = sorted.get(sortArray[i]).split(",");
            int frequency = sortArray[i];
            if (tmp.length > 1) {
                Integer[] resort = new Integer[tmp.length];
                int x = 0;
                for(String s: tmp){
                    resort[x] = Integer.valueOf(s);
                    x++;
                }
                Arrays.sort(resort, Comparator.reverseOrder());
                for (int s : resort) {
                    int count = frequency;
                    while (count > 0) {
                        ans[index] = s;
                        index++;
                        count--;
                    }
                }

            } else {
                int count = frequency;
                while (count > 0) {
                    ans[index] = Integer.valueOf(tmp[0]);
                    index++;
                    count--;
                }
            }
        }

        return ans;
    }


    public int[] _frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        /**
         * Collections sort 用法！！！
         */
        Collections.sort(list, (a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }



    public static void main(String[] args) {
        System.out.println(frequencySort(new int[]{8,2,-3,-5,-8,-8}));
    }
}
