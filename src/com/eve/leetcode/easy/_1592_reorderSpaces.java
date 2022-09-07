package com.eve.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/7.
 */
public class _1592_reorderSpaces {

    public static String reorderSpaces(String text) {

        char[] ch = text.toCharArray();
        int countspaces = 0;
        List<String> words = new LinkedList<>();
        StringBuilder w = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                countspaces++;
                if (!w.toString().isEmpty()) {
                    words.add(w.toString());
                }
                w = new StringBuilder();
            } else {
                w.append(ch[i]);
                if(i == ch.length-1){
                    words.add(w.toString());
                }
            }
        }

        int countwords = words.size();
        int spacebetween = (countwords == 1) ? 0 : countspaces / (countwords - 1);
        int spaceleft = (countwords == 1) ? countspaces : countspaces % (countwords - 1);
        StringBuilder ans = new StringBuilder();

        for (String s : words) {
            for (int i = 0; i < spacebetween; i++) {
                ans.append(' ');
            }
            ans.append(s);
        }
        String newText =  ans.toString();
        newText =  newText.substring(0,newText.length()+spaceleft-spacebetween+2);

        return newText;

    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("qknlkpp  kjoo  i"));
    }
}
