package com.eve.leetcode.competition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eve on 2022/9/5.
 */
public class _20220903_mihayou {


    public static boolean checkDistances(String s, int[] distance) {


        char[] ch  = s. toCharArray();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < ch.length; i++){
            int key = ch[i] - 97;
            if(map.containsKey(key)){
                if(distance[key] != (i-map.get(key) -1)){
                    return false;
                }
            }else{
                map.put(key,i);
            }
        }

        return true;

    }


    public int numberOfWays(int startPos, int endPos, int k) {

        if((endPos - startPos) %2 != k%2) return 0;
        if(k < (endPos - startPos)) return 0;
        int distance = endPos - startPos;
        int count = (k - distance)/2;
        int ways = 1;
        while(count>0){
            if(ways * distance * 2 > Integer.MAX_VALUE)
                ways = (1+ (distance -2)*2 * ways % (1000000000+7));
            count--;
        }
        return ways;

    }


//    public static int longestNiceSubarray(int[] nums) {
//
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp,1);
//
//        for(int i = 1; i < nums.length; i++){
//            int count = 1;
//            int sum =  nums[i];
//            int index = i-1;
//            while(sum != 0 && index >= 0){
//                sum = nums[index] & sum;
//                index --;
//                count ++;
//            }
//            if(sum != 0 ) dp[i] =  dp[i-1];
//            if(sum == 0 ){
//                dp[i] = Math.max(dp[i-1],count);
//            }
//
//        }
//
//        return dp[nums.length-1];
//
//    }


    public static int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i = 1; i < nums.length; i++){
            int count = dp[i-1];
            int index = 1;
            while(index <= count ){
                if((nums[i] & nums[i-index]) == 0 ){
                    index++;
                }else{
                    break;
                }
            }
            if(index==1){
                dp[i]= 1;
            }else{
                dp[i] = index ;
            }
            ans = Math.max(ans,dp[i]);
        }

        return ans;

    }



    public static void main(String[] args) {
        //System.out.println(checkDistances("abaccb",new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        //System.out.println(checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

        System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));


        //System.out.println(151813349 & 1048576);
        System.out.println(longestNiceSubarray(new int[]{84139415,693324769,614626365,497710833,615598711,264,65552,50331652,1,1048576,16384,544,270532608,151813349,221976871,678178917,845710321,751376227,331656525,739558112,267703680}));
    }
}
