package com.eve.leetcode.medium.iterator;

/**
 * Created by Eve on 2022/8/8.
 */


import java.util.*;

/**
 * 电话号码的字母组合
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


        示例 1：

        输入：digits = "23"
        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        示例 2：

        输入：digits = ""
        输出：[]
        示例 3：

        输入：digits = "2"
        输出：["a","b","c"]
         

        提示：

        0 <= digits.length <= 4
        digits[i] 是范围 ['2', '9'] 的一个数字。

        作者：力扣 (LeetCode)
        链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xv8ka1/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class LetterCombinations {

    //解题思路
    //回溯算法
    //队列 取出队列，然后再入队
    //可以用queue

    //我的方式是增加了额外的空间使用（tmp List）
    public static List<String> letterCombinations(String digits) {

        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        char[] dc =  digits.toCharArray();
        List<String> result = new LinkedList<>();
        int i=0;
        while(i<dc.length){
            String s =  map.get(Integer.valueOf(dc[i]+""));
            char[] sc =  s.toCharArray();
            if(result.size()==0){
                int j=0;
                while(j<sc.length){
                    result.add(sc[j]+"");
                    j++;
                }
            }else{
                int j=0;
                List<String> tmp = new LinkedList<>();
                while(j<sc.length){

                    for(Iterator<String> itr = result.iterator();itr.hasNext();){
                        tmp.add(itr.next()+sc[j]);
                    }
                    j++;
                }
                result = tmp;
            }
            i++;

        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("234"));

    }
}
