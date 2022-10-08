package com.eve.leetcode.medium.list;

/**
 * Created by Eve on 2022/8/26.
 */


import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 实现 LRUCache 类：
 LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

  

 示例：

 输入
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 输出
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 解释
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // 缓存是 {1=1}
 lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 lRUCache.get(1);    // 返回 1
 lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 lRUCache.get(2);    // 返回 -1 (未找到)
 lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 lRUCache.get(1);    // 返回 -1 (未找到)
 lRUCache.get(3);    // 返回 3
 lRUCache.get(4);    // 返回 4
  

 提示：

 1 <= capacity <= 3000
 0 <= key <= 10000
 0 <= value <= 105
 最多调用 2 * 105 次 get 和 put

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/lru-cache
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//双向链表 + 哈希表
//自己实现简单的双向链表
public class _146_LRUCache {


    private Map<Integer,DLinkedNode> cache;
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){
            key=_key;
            value=_value;
        }
    }

    public _146_LRUCache(int capacity) {

        cache = new HashMap<>();
        this.capacity =  capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkedNode node = cache.get(key);
            removeExist(node);
            addFirst(node);
            return node.value;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {


        if(cache.size() == capacity){
            if(cache.containsKey(key)){
                DLinkedNode node = new DLinkedNode(key,value);
                //remove exist one
                removeExist(cache.get(key));
                //add first
                addFirst(node);
                cache.put(key,node);
            }else{
                DLinkedNode node = new DLinkedNode(key,value);
                //remove last
                removeLast();
                //add first
                addFirst(node);
                cache.put(key,node);
            }
        }else if(cache.size() < capacity){
            if(cache.containsKey(key)){
                DLinkedNode node = new DLinkedNode(key,value);
                //remove exist one
                removeExist(cache.get(key));
                //add first
                addFirst(node);
                cache.put(key,node);
            }else{
                DLinkedNode node = new DLinkedNode(key,value);
                //add first
                addFirst(node);
                cache.put(key,node);
            }
        }

    }

    private void addFirst(DLinkedNode node){
        DLinkedNode first = head.next;
        head.next = node;
        node.next = first;
        first.prev = node;
        node.prev = head;
    }


    private void removeLast(){
        DLinkedNode last = tail.prev;
        DLinkedNode preLast = last.prev;
        preLast.next = tail;
        tail.prev = preLast;
        cache.remove(last.key);
    }

    private void removeExist(DLinkedNode node){
        DLinkedNode prev  =  node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        //cache.remove(node.key);
    }

    public static void main(String[] args) {
        _146_LRUCache cc = new _146_LRUCache(2);
        cc.put(1,1);
        cc.put(2,2);
        cc.get(1);
        cc.put(3,3);
        cc.get(2);
        cc.put(4,4);
        cc.get(1);
        cc.get(3);
        cc.get(4);

    }
}
