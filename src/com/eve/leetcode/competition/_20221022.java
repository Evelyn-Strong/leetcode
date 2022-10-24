package com.eve.leetcode.competition;

import java.util.*;
import java.util.stream.Stream;

public class _20221022 {

    public static int getLength(String[] grid) {
        int rlen = grid.length;
        int clen = grid[0].length();
        int i = 0;
        int j = 0;
        int distance = 0;
        Map<String, String> rightMap = new HashMap<>();
        rightMap.put("down", "left");
        rightMap.put("right", "up");
        rightMap.put("up", "right");
        rightMap.put("left", "down");

        Map<String, String> leftMap = new HashMap<>();
        leftMap.put("down", "right");
        leftMap.put("right", "down");
        leftMap.put("up", "left");
        leftMap.put("left", "up");
        String dt = "down";
        while (isInZone(i, j, rlen, clen)) {
            distance++;
            String[] ds = direction(dt, i, j, grid, rightMap, leftMap);
            dt = ds[0];
            i = Integer.valueOf(ds[1]);
            j = Integer.valueOf(ds[2]);
        }
        return distance;
    }

    private static boolean isInZone(int i, int j, int rlen, int clen
    ) {
        if (i < rlen && i >= 0 && j < clen && j >= 0) {
            return true;
        } else return false;
    }

    private static String[] direction(String dt, int i, int j, String[] grid, Map<String, String> rightMap, Map<String, String> leftMap) {
        String[] ds = new String[3];
        switch (grid[i].charAt(j) + "") {
            case ".": {
                ds[0] = dt;
                ds[1] = pos(dt, i, j)[0];
                ds[2] = pos(dt, i, j)[1];
                break;
            }
            case "R": {
                ds[0] = rightMap.get(dt);
                ds[1] = pos(ds[0], i, j)[0];
                ds[2] = pos(ds[0], i, j)[1];
                break;
            }
            case "L": {
                ds[0] = leftMap.get(dt);
                ds[1] = pos(ds[0], i, j)[0];
                ds[2] = pos(ds[0], i, j)[1];
                break;
            }
        }
        return ds;
    }

    private static String[] pos(String dt, int i, int j) {
        String[] ds = new String[2];
        switch (dt) {
            case "down": {
                ds[0] = i + 1 + "";
                ds[1] = j + "";
                break;
            }
            case "up": {
                ds[0] = i - 1 + "";
                ds[1] = j + "";
                break;
            }
            case "left": {
                ds[0] = i + "";
                ds[1] = j - 1 + "";
                break;
            }
            case "right": {
                ds[0] = i + "";
                ds[1] = j + 1 + "";
                break;
            }
        }
        return ds;
    }


    public static int[] arrangeBookshelf(int[] order, int limit) {
        Queue<Integer> q = new ArrayDeque<>();
        //Queue<Integer> tmp = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int book : order) {
            if (map.containsKey(book) && (map.get(book) >= limit)) {
                Queue<Integer> tmp = new ArrayDeque<>();
                while (q.size() > 0) {
                    if (q.peek() == book && map.get(book) >= limit) {
                        int pre = q.poll();

                        if (q.size()> 0 && q.peek() >= pre) {
                           tmp.offer(pre);
                        }else{
                            map.put(book, map.get(book) - 1);
                        }
                    }else{
                        tmp.offer(q.poll());
                    }
                }
                if(map.get(book) < limit){
                    tmp.offer(book);
                    map.put(book, map.getOrDefault(book, 0) + 1);
                }
                q = tmp;
            } else {
                map.put(book, map.getOrDefault(book, 0) + 1);
                q.offer(book);
            }

        }
        int[] ans = new int[q.size()];
        int index = 0;
        while (q.size() > 0) {
            ans[index] = q.poll();
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(getLength(new String[]{"...", "L.L", "RR.", "L.R"}));
        System.out.println(arrangeBookshelf(new int[]{3,3,9,8,9,2,8},1));
    }
}
