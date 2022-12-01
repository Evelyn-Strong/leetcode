package com.eve.leetcode.medium;

public class _809_expressiveWords {

    public static int expressiveWords(String s, String[] words) {
        int res = 0;
        boolean isExpand = true;
        for (String word : words) {
            if(s.length() < word.length()) continue;
            char c = word.charAt(0);
            int sp = 0, wp = 0;
            isExpand = true;
            while (wp < word.length()) {
                int count1 =  1;
                while (wp < word.length()-1 && c == word.charAt(wp+1)) {
                    wp++;
                    count1++;
                }
                int count2 = 0;
                while (sp < s.length() && s.charAt(sp) == c) {
                    count2++;
                    sp++;
                }
                if (!(count2-count1 == 0 || count2 >= 3)) {
                    isExpand = false;
                    break;
                }else{
                    if(++wp < word.length()){
                        c = word.charAt(wp);
                    }
                }
            }
            if(isExpand && sp == s.length() && wp == word.length()){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(expressiveWords("heeelllooo", new String[]{"hello"}));
    }

}
