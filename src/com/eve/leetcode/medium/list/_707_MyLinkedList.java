package com.eve.leetcode.medium.list;

/**
 * Created by Eve on 2022/9/23.
 */

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _707_MyLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
            val = 0;
            next = null;
        }

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    ListNode dummyhead;
    ListNode dummytail;
    int size;

    public _707_MyLinkedList() {
        dummyhead = new ListNode();
        dummytail = new ListNode();
        size = 0;
    }

    public int get(int index) {
        if (index + 1 > size) return -1;
        ListNode head = dummyhead.next;
        int val = head.val;
        while (index >= 0) {
            val = head.val;
            head = head.next;
            index--;
        }
        return val;
    }

    public void addAtHead(int val) {

        ListNode head = dummyhead.next;
        ListNode newHead = new ListNode(val);
        if (head == null) {
            dummyhead.next = newHead;
        } else {
            dummyhead.next = newHead;
            newHead.next = head;
        }
        size++;

    }

    public void addAtTail(int val) {
        ListNode node = dummyhead.next;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
        size++;

    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index <= 0 ){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        ListNode head = dummyhead.next;
        while (index-2 >= 0) {
            head = head.next;
            index--;
        }
        ListNode after =  head.next;
        ListNode insert = new ListNode(val);
        head.next =  insert;
        insert.next = after;

        size++;
    }

    public void deleteAtIndex(int index) {
        if(index +1 > size || index <0){
            return;
        }else{
            if(size == 1){
                dummyhead.next =  null;
                size--;
                return;
            }
            ListNode head = dummyhead;
            while (index-1 >= 0) {
                head = head.next;
                index--;
            }
            ListNode after =  head.next.next;
            head.next =  after;
            size--;
        }
    }


    public static void main(String[] args) {
        _707_MyLinkedList linkedList = new _707_MyLinkedList();
//        linkedList.addAtHead(7);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(3,0);
//        linkedList.deleteAtIndex(2);
//        linkedList.addAtHead(6);
//        linkedList.addAtTail(4);
//        linkedList.get(4);
//        linkedList.addAtHead(4);
//        linkedList.addAtIndex(5,0);
//        linkedList.addAtHead(6);


        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        linkedList.get(1);
        linkedList.deleteAtIndex(2);
        linkedList.get(0);



    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
