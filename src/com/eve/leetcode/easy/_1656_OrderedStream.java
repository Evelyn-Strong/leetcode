package com.eve.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Eve on 2022/8/16.
 */
public class _1656_OrderedStream {



        private String[] stream;
        private int ptr;

        public _1656_OrderedStream(int n) {
            stream =  new String[n+1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            List<String> list =  new LinkedList<>();
            stream[idKey] = value;
            if(ptr == idKey){
                while( ptr < stream.length && !stream[ptr].isEmpty()){
                    list.add(stream[ptr]);
                    ptr++;
                }
            }
            return list;

    }
}


