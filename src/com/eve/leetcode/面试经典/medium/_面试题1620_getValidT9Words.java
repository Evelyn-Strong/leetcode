package com.eve.leetcode.面试经典.medium;

import java.util.*;
import java.util.stream.Stream;

public class _面试题1620_getValidT9Words {

    public static List<String> getValidT9Words(String num, String[] words) {
        String[] keyboard = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Map<String,Integer> map = new HashMap<>();
        for(int i  = 0; i < keyboard.length; i++){
            for(char c: keyboard[i].toCharArray()){
                map.put(c+"", i+2);
            }
        }
        char[][] wchar = new char[words.length][num.length()];
        for(int i  = 0; i < words.length; i++){
            wchar[i] =  words[i].toCharArray();
        }
        Arrays.sort(wchar, (a, b) -> {
            int i = 0;
            while (i < num.length()-1 && map.get(a[i]+"") == map.get(b[i]+"")) {
                i++;
            }
            return map.get(a[i]+"") - map.get(b[i]+"");
        });
        int start = 0;
        int end = words.length;
        for(int i = 0; i < num.length();i++){
            int n = Integer.valueOf(num.charAt(i)+"")-2;
            int nextEnd = end-1;
            while(start <= nextEnd && !keyboard[n].contains(wchar[start][i]+"")){
                start++;
            }
            end = start;
            while(end <= nextEnd && keyboard[n].contains(wchar[end][i]+"")){
                end++;
            }
        }
        List<String> ans = new LinkedList<>();
        for(int i= start;i < end;i++){
            StringBuilder sb = new StringBuilder();
            for(char c: wchar[i]){
                sb.append(c);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        getValidT9Words("9675973753",new String[]{"alasvnpzur", "znwdgoiwso", "wduzrpnqrv", "ymrkxqdrlf", "epsqjclyqe", "zopjysdqke", "zhfxsdeimz", "eitgrsdnvt"});
    }
}
