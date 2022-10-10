package com.eve.leetcode.hard;

/**
 * Created by Eve on 2022/9/21.
 */
public class _854_kSimilarity {

    public static int kSimilarity(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int len = ch1.length;
        int count = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == ch2[i]) continue;
            else {
                int x = i + 1;
                while (x < len) {
                    if (ch1[x] == ch2[i]) {
                        char tmp = ch1[i];
                        ch1[i] = ch2[i];
                        ch1[x] = tmp;
                        count++;
                        x++;
                    }else{
                        x++;
                    }
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(kSimilarity("abeeddf","edfabde"));
    }
}
