package com.eve.leetcode.competition;

import com.eve.leetcode.medium.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class _20221119 {

    public static int unequalTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int len = set.size();
        if (len < 3) return 0;
        Integer[] it = set.toArray(new Integer[set.size()]);
        int sum = 0;
        for (int x = 0; x < len; ++x) {
            for (int y = x + 1; y < len; ++y) {
                for (int z = y + 1; z < len; ++z) {
                    sum += map.get(it[x]) * map.get(it[y]) * map.get(it[z]);
                }
            }
        }
        return sum;
    }


    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        // convert BST to array
        Queue<TreeNode> queue = new ArrayDeque<>();
        dfs(queue, root);
        Integer[] nums = new Integer[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            nums[index] = queue.poll().val;
            index++;
        }
        System.out.println(nums.length);
        List<List<Integer>> ls = new LinkedList<>();
        for (int target : queries) {
            ls.add(Arrays.asList(binarySearch(nums, target)));
        }
        return ls;
    }

    private static void dfs(Queue<TreeNode> queue, TreeNode root) {

        if (root == null) return;
        dfs(queue, root.left);
        queue.offer(root);
        dfs(queue, root.right);
    }

    private static Integer[] binarySearch(Integer[] nums, int target) {
        if (target < nums[0]) return new Integer[]{-1, nums[0]};
        if (target > nums[nums.length - 1]) return new Integer[]{nums[nums.length - 1], -1};
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (right - left == 1) {
                if (nums[right] == target || nums[left] == target)
                    return new Integer[]{target, target};
                return new Integer[]{nums[left], nums[right]};
            }
            if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            mid = left + (right - left) / 2;
        }
        return null;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] connect : roads) {
            // map.put(connect[0],)
        }

        return 0L;

    }

     static Set<Character> set = Arrays.stream(new Character[]{'2', '3', '5', '7'}).collect(Collectors.toSet());

    public static  int beautifulPartitions(String s, int k, int minLength) {
        int count = 0;
        if(s.isEmpty()) return 0;
        if (set.contains(s.charAt(s.length() - 1))) return 0;
        if(k == 1){
            if (set.contains(s.charAt(0))) return 1;
            else return 0;
        }
        for (int i = s.length() - minLength - 1; i >= 0; --i) {
            if (set.contains(s.charAt(i))){
                count+=beautifulPartitions(s.substring(0,i),k-1,minLength);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        // System.out.println(binarySearch(new Integer[]{1, 2, 3, 4, 6, 7, 19}, 5));
        System.out.println(beautifulPartitions("23542185131",2,2));
    }
}
