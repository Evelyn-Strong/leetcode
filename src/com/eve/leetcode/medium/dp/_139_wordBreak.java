package com.eve.leetcode.medium.dp;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Eve on 2022/8/25.
 */
public class _139_wordBreak {


    public static boolean wordBreak(String s, List<String> wordDict) {

          boolean[] dp =  new boolean[s.length()];
          boolean[] visited =  new boolean[s.length()];
          boolean ans = helper(s,wordDict,dp,visited);
        return ans;

    }

    /**
     * 光回溯+ split会有bug 譬如ccaccc，cc，ac
     * @param args
     */
//    private static boolean helper(String s, List<String> wordDict){
//        if(s.isEmpty()) return true;
//        if(wordDict.isEmpty() && !s.isEmpty()) return false;
//
//        boolean ans = true;
//
//        String[] split = null;
//        List<String> wl = new LinkedList<>();
//        wl = wordDict;
//        for(int i = 0 ; i<wordDict.size();i++){
//            String word =  wordDict.get(i);
//            split =  s.split(word);
//            String tmp ="";
//            for(String a: split){
//                if(!a.isEmpty()){
//                    ans = true;
//                    wl.remove(word);
//                    ans = ans && helper(a,wl);
//                    wl.add(word);
//                }
//                tmp+=a;
//            }
//
//            if(ans || tmp.isEmpty()) return true;
//
//        }
//         return ans;
//    }

    /**
     * 动态规划
     * dp[j] = dp[i] + word;
     * if(dp[i] == true)
     * @param args
     */

    private static boolean helper(String s, List<String> wordDict, boolean[] dp,boolean[] visited){


       // Set<String> wordDictSet = new HashSet(wordDict);

        if(s.isEmpty()) return true;
        if(visited[s.length()-1]){
            return dp[s.length()-1];
        }
        List<String> wl = new LinkedList<>();
        wl = wordDict;
        boolean ans = false;
        for(int i=0;i<wordDict.size();i++){
            String word =  wordDict.get(i);
            int slen =  s.length();
            int wlen = word.length();
            if(slen>=wlen && s.substring(slen-wlen,slen).equals(word)){
                ans = true;
                ans = ans && helper(s.substring(0,slen-wlen),wordDict,dp,visited);
            }
            if(ans) {
                visited[s.length()-1] = true;
                dp[s.length()-1] = ans;
                return ans;
            }

        }
        visited[s.length()-1] = true;
        dp[s.length()-1] = ans;
        return ans;

    }



    public static void main(String[] args) {
        String s = "ccaccc";
        List<String> ls =  new LinkedList<>();
        ls.add("ac");
        ls.add("ccc");
        ls.add("gs");
        System.out.println(wordBreak(s,ls));
    }
}
