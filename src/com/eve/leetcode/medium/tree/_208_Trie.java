package com.eve.leetcode.medium.tree;


/**
 * Created by Eve on 2022/8/28.
 */
/*
 * Dictionary Tree will include 26 characters [a-z] so children could only include array length 26
 * Dictionary Tree top root is empty.
 */
public class _208_Trie {

    //不用指定这个Trie的值，直接从上级指定的index可以推断出
    _208_Trie[] children;
    boolean isEnd;

    public _208_Trie() {
        children = new _208_Trie[26];
        isEnd =  false;
    }

    public void insert(String word) {
        _208_Trie trie =  this;
       for(int i=0;i<word.length();i++){
           int index = word.charAt(i)-'a';
           if(children[index] == null){
               children[index] = new _208_Trie();
           }
         trie = trie.children[index];
      }
      trie.isEnd = true;
    }

    public boolean search(String word) {
       return searchPrefix(word)!= null && searchPrefix(word).isEnd;

    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;

    }

    private _208_Trie searchPrefix(String prefix){
        _208_Trie trie = this;
        for(int i = 0; i< prefix.length(); i++ ){
            int index = prefix.charAt(i) - 'a';
            if(children[index] == null) return null;
            else{
                trie = trie.children[index];
            }
        }
        return trie;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
