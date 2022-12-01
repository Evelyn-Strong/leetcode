package com.eve.leetcode.competition;

import sun.awt.image.ImageWatched;

import java.util.*;

import static javax.swing.text.html.HTML.Tag.OL;

public class _20221030 {

    public static int averageValue(int[] nums) {
        long sum = 0;
        int count = 0;
        for (int i : nums) {
            if (i % 6 == 0) {
                sum += i;
                count++;
            }
        }
        if (count == 0) return 0;
        return (int) sum / count;
    }


    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> mapping = new HashMap<>();
        int len = creators.length;
        List<List<String>> ans = new LinkedList<>();
        List<String> topCreators = new LinkedList<>();
        int maxViews = 0;
        for (int i = 0; i < len; i++) {
            map.put(creators[i], map.getOrDefault(creators[i], 0) + views[i]);
            List<Integer> indexs = mapping.getOrDefault(creators[i], new LinkedList<>());
            indexs.add(i);
            mapping.put(creators[i], indexs);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxViews) {
                topCreators.clear();
                topCreators.add(entry.getKey());
                maxViews = entry.getValue();
            } else if (entry.getValue() == maxViews) {
                topCreators.add(entry.getKey());
            }
        }
        for (String creator : topCreators) {
            List<String> ci = new LinkedList<>();
            ci.add(creator);
            ci.add(findTopId(mapping.get(creator), ids, views));
            ans.add(ci);
        }
        return ans;

    }

    private static String findTopId(List<Integer> indexs, String[] ids, int[] views) {
        if (indexs.size() == 1) return ids[indexs.get(0)];
        String id = ids[indexs.get(0)];
        Integer maxView = views[indexs.get(0)];
        for (int i = 1; i < indexs.size(); i++) {
            if (views[indexs.get(i)] > maxView) {
                maxView = views[indexs.get(i)];
                id = ids[indexs.get(i)];
            } else if (views[indexs.get(i)] == maxView) {
                if (ids[indexs.get(i)].compareTo(id) < 0) {
                    id = ids[indexs.get(i)];
                }
            }
        }
        return id;
    }


    public static long makeIntegerBeautiful(long n, int target) {
        if (n == target) return 0;
        String sn = n + "";
        int osum = 0;
        for (char c : sn.toCharArray()) {
            osum += Integer.valueOf(c + "");
        }
        if(osum <= target) return 0;
        int len = sn.length();
        List<Integer> ls = new LinkedList<>();
        boolean flag = false;
        int i = len - 1;
        boolean start = false;
        while (i >= 0) {
            if(i == len-1 && Integer.valueOf(sn.charAt(i) + "") ==0){
                i--;
                ls.add(0);
                while(i >=0 && Integer.valueOf(sn.charAt(i) + "") ==0){
                    i--;
                    ls.add(0);
                }
                start = true;
            }
            int delete = (i == len-1 || start)? Integer.valueOf(sn.charAt(i) + ""): Integer.valueOf(sn.charAt(i) + "")+1;
            int pn = 10 - delete;
            ls.add(pn);
            i--;
            while (i >= 0 && sn.charAt(i) == '9') {
                delete += 9;
                ls.add(0);
                i--;
            }
            osum -= delete;
            osum++;
            if (osum <= target) {
                flag = true;
                break;
            }
            start = false;

        }
        if (flag) {

            StringBuilder sb  = new StringBuilder();
            for(int m  = ls.size()-1; m >=0; m--){
                sb.append(ls.get(m));
            }
            return Long.valueOf(sb.toString());
        } else return 0;

    }

    public static void main(String[] args) {
        //System.out.println(averageValue(new int[]{4, 4, 9, 10}));
        //System.out.println(mostPopularCreator(new String[]{"alice", "bob", "alice", "chris"}, new String[]{"one", "two", "three", "four"}, new int[]{5, 10, 5, 4}));
        //System.out.println("one".compareTo("three") > 0);

        System.out.println(makeIntegerBeautiful(6068060761L ,3));
    }


}
